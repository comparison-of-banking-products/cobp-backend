package ru.cobp.backend.deposit.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.cobp.backend.deposit.entity.QDeposit;
import ru.cobp.backend.deposit.service.DepositService;

@Service
@RequiredArgsConstructor
public class DepositServiceImpl implements DepositService {

    private static final QDeposit Q_DEPOSIT = QDeposit.deposit;

}
