INSERT INTO banks (bic, name, legal_entity, description, logo, url)
VALUES
    (1, 'ban4ok-1', 'ban4ok-1-legalnyy', 'dlya vas svezhenkiy tovarchik, a dlya nas - solidnyy navarchik', 'ban4ok-1-logo', 'ban4ok-1-url'),
    (2, 'ban4ok-2', 'ban4ok-2-legalnyy', 'u kogo net nalichnykh, budet rydat neprilichno', 'ban4ok-2-logo', 'ban4ok-2-url'),
    (044525974, 'Тинькофф Банк', '?', 'Онлайн-экосистема, основанная на финансовых и лайфстайл-услугах', 'logo', 'https://www.tinkoff.ru'),
    (044525187, 'Банк ВТБ', '??', 'Системообразующий универсальный российский банк', 'logo', 'https://www.vtb.ru'),
    (044525823, 'Газпромбанк', '???', 'Один из крупнейших универсальных финансовых институтов России', 'logo', 'https://www.gazprombank.ru');

INSERT INTO currencies (num, code, currency)
VALUES (643, 'RUB', 'Russian ruble');

INSERT INTO deposits (bank_bic, name, product_url, is_active, currency_num, amount_min, amount_max, term, rate)
VALUES
    (044525974, 'Тинькофф Вклад, без подписки', 'https://www.tinkoff.ru/savings/deposit/', true, 643, 50000, 30000000, 3, 14.50),
    (044525974, 'Тинькофф Вклад, без подписки', 'https://www.tinkoff.ru/savings/deposit/', true, 643, 50000, 30000000, 4, 14.50),
    (044525974, 'Тинькофф Вклад, без подписки', 'https://www.tinkoff.ru/savings/deposit/', true, 643, 50000, 30000000, 5, 14.50),

    (044525974, 'Тинькофф Вклад, без подписки', 'https://www.tinkoff.ru/savings/deposit/', true, 643, 50000, 30000000, 6, 14.10),
    (044525974, 'Тинькофф Вклад, без подписки', 'https://www.tinkoff.ru/savings/deposit/', true, 643, 50000, 30000000, 7, 14.10),
    (044525974, 'Тинькофф Вклад, без подписки', 'https://www.tinkoff.ru/savings/deposit/', true, 643, 50000, 30000000, 8, 14.10),
    (044525974, 'Тинькофф Вклад, без подписки', 'https://www.tinkoff.ru/savings/deposit/', true, 643, 50000, 30000000, 9, 14.10),
    (044525974, 'Тинькофф Вклад, без подписки', 'https://www.tinkoff.ru/savings/deposit/', true, 643, 50000, 30000000, 10, 14.10),
    (044525974, 'Тинькофф Вклад, без подписки', 'https://www.tinkoff.ru/savings/deposit/', true, 643, 50000, 30000000, 11, 14.10),

    (044525974, 'Тинькофф Вклад, без подписки', 'https://www.tinkoff.ru/savings/deposit/', true, 643, 50000, 30000000, 12, 13.00),
    (044525974, 'Тинькофф Вклад, без подписки', 'https://www.tinkoff.ru/savings/deposit/', true, 643, 50000, 30000000, 13, 13.00),
    (044525974, 'Тинькофф Вклад, без подписки', 'https://www.tinkoff.ru/savings/deposit/', true, 643, 50000, 30000000, 14, 13.00),
    (044525974, 'Тинькофф Вклад, без подписки', 'https://www.tinkoff.ru/savings/deposit/', true, 643, 50000, 30000000, 15, 13.00),
    (044525974, 'Тинькофф Вклад, без подписки', 'https://www.tinkoff.ru/savings/deposit/', true, 643, 50000, 30000000, 16, 13.00),
    (044525974, 'Тинькофф Вклад, без подписки', 'https://www.tinkoff.ru/savings/deposit/', true, 643, 50000, 30000000, 17, 13.00),

    (044525974, 'Тинькофф Вклад, без подписки', 'https://www.tinkoff.ru/savings/deposit/', true, 643, 50000, 30000000, 18, 12.00),
    (044525974, 'Тинькофф Вклад, без подписки', 'https://www.tinkoff.ru/savings/deposit/', true, 643, 50000, 30000000, 19, 12.00),
    (044525974, 'Тинькофф Вклад, без подписки', 'https://www.tinkoff.ru/savings/deposit/', true, 643, 50000, 30000000, 20, 12.00),
    (044525974, 'Тинькофф Вклад, без подписки', 'https://www.tinkoff.ru/savings/deposit/', true, 643, 50000, 30000000, 21, 12.00),
    (044525974, 'Тинькофф Вклад, без подписки', 'https://www.tinkoff.ru/savings/deposit/', true, 643, 50000, 30000000, 22, 12.00),
    (044525974, 'Тинькофф Вклад, без подписки', 'https://www.tinkoff.ru/savings/deposit/', true, 643, 50000, 30000000, 23, 12.00),
    (044525974, 'Тинькофф Вклад, без подписки', 'https://www.tinkoff.ru/savings/deposit/', true, 643, 50000, 30000000, 24, 12.00),

    (044525187, 'ВТБ Вклад, без пополнения и без снятия', 'https://www.vtb.ru/personal/vklady-i-scheta/vtb-vklad-r/', true, 643, 10000, 499999, 3, 13.14),
    (044525187, 'ВТБ Вклад, без пополнения и без снятия', 'https://www.vtb.ru/personal/vklady-i-scheta/vtb-vklad-r/', true, 643, 10000, 499999, 6, 13.56),
    (044525187, 'ВТБ Вклад, без пополнения и без снятия', 'https://www.vtb.ru/personal/vklady-i-scheta/vtb-vklad-r/', true, 643, 10000, 499999, 12, 13.48),
    (044525187, 'ВТБ Вклад, без пополнения и без снятия', 'https://www.vtb.ru/personal/vklady-i-scheta/vtb-vklad-r/', true, 643, 10000, 499999, 18, 8.50),
    (044525187, 'ВТБ Вклад, без пополнения и без снятия', 'https://www.vtb.ru/personal/vklady-i-scheta/vtb-vklad-r/', true, 643, 10000, 499999, 24, 8.65),
    (044525187, 'ВТБ Вклад, без пополнения и без снятия', 'https://www.vtb.ru/personal/vklady-i-scheta/vtb-vklad-r/', true, 643, 10000, 499999, 36, 15.00),

    (044525187, 'ВТБ Вклад, без пополнения и без снятия', 'https://www.vtb.ru/personal/vklady-i-scheta/vtb-vklad-r/', true, 643, 500000, 5000000, 3, 13.35),
    (044525187, 'ВТБ Вклад, без пополнения и без снятия', 'https://www.vtb.ru/personal/vklady-i-scheta/vtb-vklad-r/', true, 643, 500000, 5000000, 6, 13.88),
    (044525187, 'ВТБ Вклад, без пополнения и без снятия', 'https://www.vtb.ru/personal/vklady-i-scheta/vtb-vklad-r/', true, 643, 500000, 5000000, 12, 13.82),
    (044525187, 'ВТБ Вклад, без пополнения и без снятия', 'https://www.vtb.ru/personal/vklady-i-scheta/vtb-vklad-r/', true, 643, 500000, 5000000, 18, 8.50),
    (044525187, 'ВТБ Вклад, без пополнения и без снятия', 'https://www.vtb.ru/personal/vklady-i-scheta/vtb-vklad-r/', true, 643, 500000, 5000000, 24, 8.65),
    (044525187, 'ВТБ Вклад, без пополнения и без снятия', 'https://www.vtb.ru/personal/vklady-i-scheta/vtb-vklad-r/', true, 643, 500000, 5000000, 36, 15.00),

    (044525823, 'Газпромбанк Вклад "В Плюсе", без привилегий и без капитализации', 'https://www.gazprombank.ru/personal/increase/deposits/detail/7476877/', true, 643, 15000, 100000000, 1, 13.50),
    (044525823, 'Газпромбанк Вклад "В Плюсе", без привилегий и без капитализации', 'https://www.gazprombank.ru/personal/increase/deposits/detail/7476877/', true, 643, 15000, 100000000, 3, 13.74),
    (044525823, 'Газпромбанк Вклад "В Плюсе", без привилегий и без капитализации', 'https://www.gazprombank.ru/personal/increase/deposits/detail/7476877/', true, 643, 15000, 100000000, 4, 13.66),
    (044525823, 'Газпромбанк Вклад "В Плюсе", без привилегий и без капитализации', 'https://www.gazprombank.ru/personal/increase/deposits/detail/7476877/', true, 643, 15000, 100000000, 6, 14.50),
    (044525823, 'Газпромбанк Вклад "В Плюсе", без привилегий и без капитализации', 'https://www.gazprombank.ru/personal/increase/deposits/detail/7476877/', true, 643, 15000, 100000000, 12, 11.34),
    (044525823, 'Газпромбанк Вклад "В Плюсе", без привилегий и без капитализации', 'https://www.gazprombank.ru/personal/increase/deposits/detail/7476877/', true, 643, 15000, 100000000, 24, 7.63),
    (044525823, 'Газпромбанк Вклад "В Плюсе", без привилегий и без капитализации', 'https://www.gazprombank.ru/personal/increase/deposits/detail/7476877/', true, 643, 15000, 100000000, 36, 10.53),

    (044525823, 'Газпромбанк Вклад "Копить", для всех и без капитализации', 'https://www.gazprombank.ru/personal/increase/deposits/detail/2491/', true, 643, 15000, 100000000, 1, 13.80),
    (044525823, 'Газпромбанк Вклад "Копить", для всех и без капитализации', 'https://www.gazprombank.ru/personal/increase/deposits/detail/2491/', true, 643, 15000, 100000000, 3, 14.04),
    (044525823, 'Газпромбанк Вклад "Копить", для всех и без капитализации', 'https://www.gazprombank.ru/personal/increase/deposits/detail/2491/', true, 643, 15000, 100000000, 4, 13.96),
    (044525823, 'Газпромбанк Вклад "Копить", для всех и без капитализации', 'https://www.gazprombank.ru/personal/increase/deposits/detail/2491/', true, 643, 15000, 100000000, 6, 14.83),
    (044525823, 'Газпромбанк Вклад "Копить", для всех и без капитализации', 'https://www.gazprombank.ru/personal/increase/deposits/detail/2491/', true, 643, 15000, 100000000, 12, 11.64),
    (044525823, 'Газпромбанк Вклад "Копить", для всех и без капитализации', 'https://www.gazprombank.ru/personal/increase/deposits/detail/2491/', true, 643, 15000, 100000000, 24, 7.93),
    (044525823, 'Газпромбанк Вклад "Копить", для всех и без капитализации', 'https://www.gazprombank.ru/personal/increase/deposits/detail/2491/', true, 643, 15000, 100000000, 36, 10.83);

INSERT INTO credits (bank_bic, name, product_url, is_active, currency_num, amount_min, amount_max, term, rate)
VALUES
    (1, 'credit-1%', 'credit-1%-url', true, 643, 10000, 1000000, 12, 1.0),
    (2, 'credit-3%', 'credit-3%-url', true, 643, 10000, 1000000, 12, 3.0);
