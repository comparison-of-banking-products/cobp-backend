package ru.cobp.backend.service.credit;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import ru.cobp.backend.common.TestUtils;
import ru.cobp.backend.dto.credit.CreditDto;
import ru.cobp.backend.dto.credit.CreditParams;
import ru.cobp.backend.dto.credit.NewCreditDto;
import ru.cobp.backend.exception.NotFoundException;
import ru.cobp.backend.model.bank.Bank;
import ru.cobp.backend.model.credit.Credit;
import ru.cobp.backend.model.currency.Currency;
import ru.cobp.backend.repository.credit.CreditRepository;
import ru.cobp.backend.service.bank.BankService;
import ru.cobp.backend.service.currency.CurrencyService;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CreditServiceTest {

    @Mock
    private CreditRepository creditRepository;

    @Mock
    private CurrencyService currencyService;

    @Mock
    private BankService bankService;

    @InjectMocks
    private CreditServiceImpl creditService;

    @Captor
    private ArgumentCaptor<Credit> creditCapture;

    @Test
    void getAll_whenValid_thenReturnedCredits() {
        List<Credit> expectedList = List.of(TestUtils.buildGazprombankCredit());
        Pageable page = PageRequest.of(0, 10, Sort.by("rate").ascending());
        CreditParams params = new CreditParams(null, null, null, null, null,
                null, null, null, null, null, null);
        Predicate p = new BooleanBuilder();

        when(creditRepository.findAll(p, page)).thenReturn(new PageImpl<>(expectedList));

        List<Credit> actualList = creditService.getAll(params, 0, 10);
        assertEquals(expectedList, actualList);
    }

    @Test
    void getById_whenFound_thenReturnedCredit() {
        long creditId = 1L;
        Credit expectedCredit = TestUtils.buildGazprombankCredit();

        when(creditRepository.findById(creditId)).thenReturn(Optional.of(expectedCredit));

        Credit actualCredit = creditService.getById(creditId);

        assertEquals(expectedCredit, actualCredit);
    }

    @Test
    void getById_whenNotFound_thenNotFoundExceptionThrown() {
        long creditId = 2L;

        when(creditRepository.findById(creditId)).thenReturn(Optional.empty());

        assertThrows(NotFoundException.class, () -> creditService.getById(creditId));
    }

    @Test
    void createCredit_whenValid_thenReturnedCredit() {
        NewCreditDto newCreditDto = TestUtils.buildNewGazprombankCreditDto();
        Bank bank = TestUtils.buildGazprombank();
        Currency currency = TestUtils.buildRubCurrency();
        Credit expectedCredit = TestUtils.buildGazprombankCredit();

        when(bankService.getBankByBicOrThrowException(newCreditDto.getBankBic())).thenReturn(bank);
        when(currencyService.getById(newCreditDto.getCurrencyNum())).thenReturn(currency);
        when(creditRepository.save(any(Credit.class))).thenReturn(expectedCredit);

        Credit actualCredit = creditService.create(newCreditDto);
        assertEquals(expectedCredit, actualCredit);
        verify(creditRepository).save(creditCapture.capture());
        Credit savedCredit = creditCapture.getValue();
        assertEquals(expectedCredit.getName(), savedCredit.getName());
        assertEquals(expectedCredit.getProductUrl(), savedCredit.getProductUrl());
        assertEquals(expectedCredit.getTerm(), savedCredit.getTerm());
        assertEquals(expectedCredit.getRate(), savedCredit.getRate());
    }

    @Test
    void createCredit_whenBankOrCurrencyNotValid_thenNotFoundExceptionThrown() {
        NewCreditDto newCreditDto = TestUtils.buildNewGazprombankCreditDto();

        when(bankService.getBankByBicOrThrowException(newCreditDto.getBankBic())).thenThrow(NotFoundException.class);

        assertThrows(NotFoundException.class, () -> creditService.create(newCreditDto));

    }

    @Test
    void updateCredit_whenValid_thenReturnedCredit() {
        Long creditId = 1L;
        CreditDto creditDto = TestUtils.buildGazprombankCreditDto();
        Credit credit = TestUtils.buildGazprombankCredit();
        Credit expectedCredit = TestUtils.buildGazprombankUpdatedCredit();

        when(creditRepository.findById(creditId)).thenReturn(Optional.of(credit));
        when(creditRepository.save(any(Credit.class))).thenReturn(expectedCredit);

        Credit actualCredit = creditService.update(creditId, creditDto);
        assertEquals(expectedCredit, actualCredit);
        verify(creditRepository).save(creditCapture.capture());
        Credit savedCredit = creditCapture.getValue();
        assertEquals(expectedCredit.getName(), savedCredit.getName());
        assertEquals(expectedCredit.getProductUrl(), savedCredit.getProductUrl());
        assertEquals(expectedCredit.getTerm(), savedCredit.getTerm());
        assertEquals(expectedCredit.getRate(), savedCredit.getRate());
    }

    @Test
    void updateCredit_whenCreditNotFound_thenNotFoundExceptionThrown() {
        Long creditId = 2L;

        when(creditRepository.findById(creditId)).thenReturn(Optional.empty());

        assertThrows(NotFoundException.class, () -> creditService.update(creditId, any(CreditDto.class)));
    }

    @Test
    void deleteCredit_whenValid_thenDeleteCredit() {
        Long creditId = 1L;
        Credit credit = TestUtils.buildGazprombankCredit();

        when(creditRepository.findById(creditId)).thenReturn(Optional.of(credit));

        creditService.delete(creditId);
        verify(creditRepository).deleteById(creditId);
    }

    @Test
    void deleteCredit_whenCreditNotFound_thenNotFoundExceptionThrown() {
        Long creditId = 2L;

        when(creditRepository.findById(creditId)).thenReturn(Optional.empty());

        assertThrows(NotFoundException.class, () -> creditService.delete(creditId));
    }

}
