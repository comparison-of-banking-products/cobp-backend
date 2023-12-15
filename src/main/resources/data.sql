INSERT INTO banks (bic, name, legal_entity, description, logo, url)
VALUES
    (1, 'ban4ok-1', 'ban4ok-1-legalnyy', 'dlya vas svezhenkiy tovarchik, a dlya nas - solidnyy navarchik', 'ban4ok-1-logo', 'ban4ok-1-url'),
    (2, 'ban4ok-2', 'ban4ok-2-legalnyy', 'u kogo net nalichnykh, budet rydat neprilichno', 'ban4ok-2-logo', 'ban4ok-2-url'),
    (044525974, 'Тинькофф Банк', '?', 'Онлайн-экосистема, основанная на финансовых и лайфстайл-услугах', '?', 'https://www.tinkoff.ru');

INSERT INTO currencies (num, code, currency)
VALUES (643, 'RUB', 'Russian ruble');

INSERT INTO deposits (bank_bic, name, product_url, is_active, currency_num, amount_min, amount_max, term, rate)
VALUES
    (044525974, 'Вклад 14,5%', 'https://www.tinkoff.ru/savings/deposit/', true, 643, 50000, 30000000, 3, 14.5),
    (044525974, 'Вклад 14,5%', 'https://www.tinkoff.ru/savings/deposit/', true, 643, 50000, 30000000, 4, 14.5),
    (044525974, 'Вклад 14,5%', 'https://www.tinkoff.ru/savings/deposit/', true, 643, 50000, 30000000, 5, 14.5),

    (044525974, 'Вклад 14,1%', 'https://www.tinkoff.ru/savings/deposit/', true, 643, 50000, 30000000, 6, 14.1),
    (044525974, 'Вклад 14,1%', 'https://www.tinkoff.ru/savings/deposit/', true, 643, 50000, 30000000, 7, 14.1),
    (044525974, 'Вклад 14,1%', 'https://www.tinkoff.ru/savings/deposit/', true, 643, 50000, 30000000, 8, 14.1),
    (044525974, 'Вклад 14,1%', 'https://www.tinkoff.ru/savings/deposit/', true, 643, 50000, 30000000, 9, 14.1),
    (044525974, 'Вклад 14,1%', 'https://www.tinkoff.ru/savings/deposit/', true, 643, 50000, 30000000, 10, 14.1),
    (044525974, 'Вклад 14,1%', 'https://www.tinkoff.ru/savings/deposit/', true, 643, 50000, 30000000, 11, 14.1),

    (044525974, 'Вклад 13,0%', 'https://www.tinkoff.ru/savings/deposit/', true, 643, 50000, 30000000, 12, 13.0),
    (044525974, 'Вклад 13,0%', 'https://www.tinkoff.ru/savings/deposit/', true, 643, 50000, 30000000, 13, 13.0),
    (044525974, 'Вклад 13,0%', 'https://www.tinkoff.ru/savings/deposit/', true, 643, 50000, 30000000, 14, 13.0),
    (044525974, 'Вклад 13,0%', 'https://www.tinkoff.ru/savings/deposit/', true, 643, 50000, 30000000, 15, 13.0),
    (044525974, 'Вклад 13,0%', 'https://www.tinkoff.ru/savings/deposit/', true, 643, 50000, 30000000, 16, 13.0),
    (044525974, 'Вклад 13,0%', 'https://www.tinkoff.ru/savings/deposit/', true, 643, 50000, 30000000, 17, 13.0),

    (044525974, 'Вклад 12,0%', 'https://www.tinkoff.ru/savings/deposit/', true, 643, 50000, 30000000, 18, 12.0),
    (044525974, 'Вклад 12,0%', 'https://www.tinkoff.ru/savings/deposit/', true, 643, 50000, 30000000, 19, 12.0),
    (044525974, 'Вклад 12,0%', 'https://www.tinkoff.ru/savings/deposit/', true, 643, 50000, 30000000, 20, 12.0),
    (044525974, 'Вклад 12,0%', 'https://www.tinkoff.ru/savings/deposit/', true, 643, 50000, 30000000, 21, 12.0),
    (044525974, 'Вклад 12,0%', 'https://www.tinkoff.ru/savings/deposit/', true, 643, 50000, 30000000, 22, 12.0),
    (044525974, 'Вклад 12,0%', 'https://www.tinkoff.ru/savings/deposit/', true, 643, 50000, 30000000, 23, 12.0),
    (044525974, 'Вклад 12,0%', 'https://www.tinkoff.ru/savings/deposit/', true, 643, 50000, 30000000, 24, 12.0);

INSERT INTO credits (bank_bic, name, product_url, is_active, currency_num, amount_min, amount_max, term, rate)
VALUES
    (1, 'credit-1%', 'credit-1%-url', true, 643, 10000, 1000000, 12, 1.0),
    (2, 'credit-3%', 'credit-3%-url', true, 643, 10000, 1000000, 12, 3.0);
