INSERT INTO banks (bic, name, legal_entity, description, logo, url)
VALUES
    (044525974, 'Тинькофф Банк', '?', 'Онлайн-экосистема, основанная на финансовых и лайфстайл-услугах', 'logo', 'https://www.tinkoff.ru'),
    (044525187, 'Банк ВТБ', '??', 'Системообразующий универсальный российский банк', 'logo', 'https://www.vtb.ru'),
    (044525823, 'Газпромбанк', '???', 'Один из крупнейших универсальных финансовых институтов России', 'logo', 'https://www.gazprombank.ru');

INSERT INTO currencies (num, code, currency)
VALUES (643, 'RUB', 'Russian ruble');

INSERT INTO deposits (bank_bic, name, product_url, is_active, currency_num, amount_min, amount_max, term, rate, capitalization, replenishment, partial_withdrawal)
VALUES
    (044525974, 'Тинькофф Вклад, без подписки', 'https://www.tinkoff.ru/savings/deposit/', true, 643, 50000, 30000000, 3, 14.50, false, false, false),
    (044525974, 'Тинькофф Вклад, без подписки', 'https://www.tinkoff.ru/savings/deposit/', true, 643, 50000, 30000000, 4, 14.50, false, false, false),
    (044525974, 'Тинькофф Вклад, без подписки', 'https://www.tinkoff.ru/savings/deposit/', true, 643, 50000, 30000000, 5, 14.50, false, false, false),

    (044525974, 'Тинькофф Вклад, без подписки', 'https://www.tinkoff.ru/savings/deposit/', true, 643, 50000, 30000000, 6, 14.10, false, false, false),
    (044525974, 'Тинькофф Вклад, без подписки', 'https://www.tinkoff.ru/savings/deposit/', true, 643, 50000, 30000000, 7, 14.10, false, false, false),
    (044525974, 'Тинькофф Вклад, без подписки', 'https://www.tinkoff.ru/savings/deposit/', true, 643, 50000, 30000000, 8, 14.10, false, false, false),
    (044525974, 'Тинькофф Вклад, без подписки', 'https://www.tinkoff.ru/savings/deposit/', true, 643, 50000, 30000000, 9, 14.10, false, false, false),
    (044525974, 'Тинькофф Вклад, без подписки', 'https://www.tinkoff.ru/savings/deposit/', true, 643, 50000, 30000000, 10, 14.10, false, false, false),
    (044525974, 'Тинькофф Вклад, без подписки', 'https://www.tinkoff.ru/savings/deposit/', true, 643, 50000, 30000000, 11, 14.10, false, false, false),

    (044525974, 'Тинькофф Вклад, без подписки', 'https://www.tinkoff.ru/savings/deposit/', true, 643, 50000, 30000000, 12, 13.00, false, false, false),
    (044525974, 'Тинькофф Вклад, без подписки', 'https://www.tinkoff.ru/savings/deposit/', true, 643, 50000, 30000000, 13, 13.00, false, false, false),
    (044525974, 'Тинькофф Вклад, без подписки', 'https://www.tinkoff.ru/savings/deposit/', true, 643, 50000, 30000000, 14, 13.00, false, false, false),
    (044525974, 'Тинькофф Вклад, без подписки', 'https://www.tinkoff.ru/savings/deposit/', true, 643, 50000, 30000000, 15, 13.00, false, false, false),
    (044525974, 'Тинькофф Вклад, без подписки', 'https://www.tinkoff.ru/savings/deposit/', true, 643, 50000, 30000000, 16, 13.00, false, false, false),
    (044525974, 'Тинькофф Вклад, без подписки', 'https://www.tinkoff.ru/savings/deposit/', true, 643, 50000, 30000000, 17, 13.00, false, false, false),

    (044525974, 'Тинькофф Вклад, без подписки', 'https://www.tinkoff.ru/savings/deposit/', true, 643, 50000, 30000000, 18, 12.00, false, false, false),
    (044525974, 'Тинькофф Вклад, без подписки', 'https://www.tinkoff.ru/savings/deposit/', true, 643, 50000, 30000000, 19, 12.00, false, false, false),
    (044525974, 'Тинькофф Вклад, без подписки', 'https://www.tinkoff.ru/savings/deposit/', true, 643, 50000, 30000000, 20, 12.00, false, false, false),
    (044525974, 'Тинькофф Вклад, без подписки', 'https://www.tinkoff.ru/savings/deposit/', true, 643, 50000, 30000000, 21, 12.00, false, false, false),
    (044525974, 'Тинькофф Вклад, без подписки', 'https://www.tinkoff.ru/savings/deposit/', true, 643, 50000, 30000000, 22, 12.00, false, false, false),
    (044525974, 'Тинькофф Вклад, без подписки', 'https://www.tinkoff.ru/savings/deposit/', true, 643, 50000, 30000000, 23, 12.00, false, false, false),
    (044525974, 'Тинькофф Вклад, без подписки', 'https://www.tinkoff.ru/savings/deposit/', true, 643, 50000, 30000000, 24, 12.00, false, false, false),

    (044525974, 'Тинькофф Вклад, без подписки', 'https://www.tinkoff.ru/savings/deposit/', true, 643, 50000, 30000000, 3, 12.00, false, true, false),
    (044525974, 'Тинькофф Вклад, без подписки', 'https://www.tinkoff.ru/savings/deposit/', true, 643, 50000, 30000000, 4, 12.00, false, true, false),
    (044525974, 'Тинькофф Вклад, без подписки', 'https://www.tinkoff.ru/savings/deposit/', true, 643, 50000, 30000000, 5, 12.00, false, true, false),

    (044525974, 'Тинькофф Вклад, без подписки', 'https://www.tinkoff.ru/savings/deposit/', true, 643, 50000, 30000000, 6, 11.50, false, true, false),
    (044525974, 'Тинькофф Вклад, без подписки', 'https://www.tinkoff.ru/savings/deposit/', true, 643, 50000, 30000000, 7, 11.50, false, true, false),
    (044525974, 'Тинькофф Вклад, без подписки', 'https://www.tinkoff.ru/savings/deposit/', true, 643, 50000, 30000000, 8, 11.50, false, true, false),
    (044525974, 'Тинькофф Вклад, без подписки', 'https://www.tinkoff.ru/savings/deposit/', true, 643, 50000, 30000000, 9, 11.50, false, true, false),
    (044525974, 'Тинькофф Вклад, без подписки', 'https://www.tinkoff.ru/savings/deposit/', true, 643, 50000, 30000000, 10, 11.50, false, true, false),
    (044525974, 'Тинькофф Вклад, без подписки', 'https://www.tinkoff.ru/savings/deposit/', true, 643, 50000, 30000000, 11, 11.50, false, true, false),
    (044525974, 'Тинькофф Вклад, без подписки', 'https://www.tinkoff.ru/savings/deposit/', true, 643, 50000, 30000000, 12, 11.50, false, true, false),

    (044525974, 'Тинькофф Вклад, без подписки', 'https://www.tinkoff.ru/savings/deposit/', true, 643, 50000, 30000000, 13, 7.00, false, true, false),
    (044525974, 'Тинькофф Вклад, без подписки', 'https://www.tinkoff.ru/savings/deposit/', true, 643, 50000, 30000000, 14, 7.00, false, true, false),
    (044525974, 'Тинькофф Вклад, без подписки', 'https://www.tinkoff.ru/savings/deposit/', true, 643, 50000, 30000000, 15, 7.00, false, true, false),
    (044525974, 'Тинькофф Вклад, без подписки', 'https://www.tinkoff.ru/savings/deposit/', true, 643, 50000, 30000000, 16, 7.00, false, true, false),
    (044525974, 'Тинькофф Вклад, без подписки', 'https://www.tinkoff.ru/savings/deposit/', true, 643, 50000, 30000000, 17, 7.00, false, true, false),

    (044525974, 'Тинькофф Вклад, без подписки', 'https://www.tinkoff.ru/savings/deposit/', true, 643, 50000, 30000000, 18, 6.50, false, true, false),
    (044525974, 'Тинькофф Вклад, без подписки', 'https://www.tinkoff.ru/savings/deposit/', true, 643, 50000, 30000000, 19, 6.50, false, true, false),
    (044525974, 'Тинькофф Вклад, без подписки', 'https://www.tinkoff.ru/savings/deposit/', true, 643, 50000, 30000000, 20, 6.50, false, true, false),
    (044525974, 'Тинькофф Вклад, без подписки', 'https://www.tinkoff.ru/savings/deposit/', true, 643, 50000, 30000000, 21, 6.50, false, true, false),
    (044525974, 'Тинькофф Вклад, без подписки', 'https://www.tinkoff.ru/savings/deposit/', true, 643, 50000, 30000000, 22, 6.50, false, true, false),
    (044525974, 'Тинькофф Вклад, без подписки', 'https://www.tinkoff.ru/savings/deposit/', true, 643, 50000, 30000000, 23, 6.50, false, true, false),
    (044525974, 'Тинькофф Вклад, без подписки', 'https://www.tinkoff.ru/savings/deposit/', true, 643, 50000, 30000000, 24, 6.50, false, true, false),

    (044525187, 'ВТБ Вклад', 'https://www.vtb.ru/personal/vklady-i-scheta/vtb-vklad-r/', true, 643, 10000, 499999, 3, 13.14, false, false, false),
    (044525187, 'ВТБ Вклад', 'https://www.vtb.ru/personal/vklady-i-scheta/vtb-vklad-r/', true, 643, 10000, 499999, 6, 13.56, false, false, false),
    (044525187, 'ВТБ Вклад', 'https://www.vtb.ru/personal/vklady-i-scheta/vtb-vklad-r/', true, 643, 10000, 499999, 12, 13.48, false, false, false),
    (044525187, 'ВТБ Вклад', 'https://www.vtb.ru/personal/vklady-i-scheta/vtb-vklad-r/', true, 643, 10000, 499999, 18, 8.50, false, false, false),
    (044525187, 'ВТБ Вклад', 'https://www.vtb.ru/personal/vklady-i-scheta/vtb-vklad-r/', true, 643, 10000, 499999, 24, 8.65, false, false, false),
    (044525187, 'ВТБ Вклад', 'https://www.vtb.ru/personal/vklady-i-scheta/vtb-vklad-r/', true, 643, 10000, 499999, 36, 15.00, false, false, false),

    (044525187, 'ВТБ Вклад', 'https://www.vtb.ru/personal/vklady-i-scheta/vtb-vklad-r/', true, 643, 500000, 5000000, 3, 13.35, false, false, false),
    (044525187, 'ВТБ Вклад', 'https://www.vtb.ru/personal/vklady-i-scheta/vtb-vklad-r/', true, 643, 500000, 5000000, 6, 13.88, false, false, false),
    (044525187, 'ВТБ Вклад', 'https://www.vtb.ru/personal/vklady-i-scheta/vtb-vklad-r/', true, 643, 500000, 5000000, 12, 13.82, false, false, false),
    (044525187, 'ВТБ Вклад', 'https://www.vtb.ru/personal/vklady-i-scheta/vtb-vklad-r/', true, 643, 500000, 5000000, 18, 8.50, false, false, false),
    (044525187, 'ВТБ Вклад', 'https://www.vtb.ru/personal/vklady-i-scheta/vtb-vklad-r/', true, 643, 500000, 5000000, 24, 8.65, false, false, false),
    (044525187, 'ВТБ Вклад', 'https://www.vtb.ru/personal/vklady-i-scheta/vtb-vklad-r/', true, 643, 500000, 5000000, 36, 15.00, false, false, false),

    (044525187, 'ВТБ Вклад', 'https://www.vtb.ru/personal/vklady-i-scheta/vtb-vklad-r/', true, 643, 10000, 499999, 3, 9.10, false, true, false),
    (044525187, 'ВТБ Вклад', 'https://www.vtb.ru/personal/vklady-i-scheta/vtb-vklad-r/', true, 643, 10000, 499999, 6, 8.10, false, true, false),
    (044525187, 'ВТБ Вклад', 'https://www.vtb.ru/personal/vklady-i-scheta/vtb-vklad-r/', true, 643, 10000, 499999, 12, 4.00, false, true, false),
    (044525187, 'ВТБ Вклад', 'https://www.vtb.ru/personal/vklady-i-scheta/vtb-vklad-r/', true, 643, 10000, 499999, 18, 3.00, false, true, false),
    (044525187, 'ВТБ Вклад', 'https://www.vtb.ru/personal/vklady-i-scheta/vtb-vklad-r/', true, 643, 10000, 499999, 24, 3.00, false, true, false),
    (044525187, 'ВТБ Вклад', 'https://www.vtb.ru/personal/vklady-i-scheta/vtb-vklad-r/', true, 643, 10000, 499999, 36, 3.00, false, true, false),

    (044525187, 'ВТБ Вклад', 'https://www.vtb.ru/personal/vklady-i-scheta/vtb-vklad-r/', true, 643, 500000, 5000000, 3, 9.40, false, true, false),
    (044525187, 'ВТБ Вклад', 'https://www.vtb.ru/personal/vklady-i-scheta/vtb-vklad-r/', true, 643, 500000, 5000000, 6, 8.40, false, true, false),
    (044525187, 'ВТБ Вклад', 'https://www.vtb.ru/personal/vklady-i-scheta/vtb-vklad-r/', true, 643, 500000, 5000000, 12, 4.00, false, true, false),
    (044525187, 'ВТБ Вклад', 'https://www.vtb.ru/personal/vklady-i-scheta/vtb-vklad-r/', true, 643, 500000, 5000000, 18, 3.00, false, true, false),
    (044525187, 'ВТБ Вклад', 'https://www.vtb.ru/personal/vklady-i-scheta/vtb-vklad-r/', true, 643, 500000, 5000000, 24, 3.00, false, true, false),
    (044525187, 'ВТБ Вклад', 'https://www.vtb.ru/personal/vklady-i-scheta/vtb-vklad-r/', true, 643, 500000, 5000000, 36, 3.00, false, true, false),

    (044525187, 'ВТБ Вклад', 'https://www.vtb.ru/personal/vklady-i-scheta/vtb-vklad-r/', true, 643, 10000, 499999, 3, 9.00, false, true, true),
    (044525187, 'ВТБ Вклад', 'https://www.vtb.ru/personal/vklady-i-scheta/vtb-vklad-r/', true, 643, 10000, 499999, 6, 8.00, false, true, true),
    (044525187, 'ВТБ Вклад', 'https://www.vtb.ru/personal/vklady-i-scheta/vtb-vklad-r/', true, 643, 10000, 499999, 12, 4.00, false, true, true),
    (044525187, 'ВТБ Вклад', 'https://www.vtb.ru/personal/vklady-i-scheta/vtb-vklad-r/', true, 643, 10000, 499999, 18, 3.00, false, true, true),
    (044525187, 'ВТБ Вклад', 'https://www.vtb.ru/personal/vklady-i-scheta/vtb-vklad-r/', true, 643, 10000, 499999, 24, 3.00, false, true, true),
    (044525187, 'ВТБ Вклад', 'https://www.vtb.ru/personal/vklady-i-scheta/vtb-vklad-r/', true, 643, 10000, 499999, 36, 3.00, false, true, true),

    (044525187, 'ВТБ Вклад', 'https://www.vtb.ru/personal/vklady-i-scheta/vtb-vklad-r/', true, 643, 500000, 5000000, 3, 9.30, false, true, true),
    (044525187, 'ВТБ Вклад', 'https://www.vtb.ru/personal/vklady-i-scheta/vtb-vklad-r/', true, 643, 500000, 5000000, 6, 8.30, false, true, true),
    (044525187, 'ВТБ Вклад', 'https://www.vtb.ru/personal/vklady-i-scheta/vtb-vklad-r/', true, 643, 500000, 5000000, 12, 4.00, false, true, true),
    (044525187, 'ВТБ Вклад', 'https://www.vtb.ru/personal/vklady-i-scheta/vtb-vklad-r/', true, 643, 500000, 5000000, 18, 3.00, false, true, true),
    (044525187, 'ВТБ Вклад', 'https://www.vtb.ru/personal/vklady-i-scheta/vtb-vklad-r/', true, 643, 500000, 5000000, 24, 3.00, false, true, true),
    (044525187, 'ВТБ Вклад', 'https://www.vtb.ru/personal/vklady-i-scheta/vtb-vklad-r/', true, 643, 500000, 5000000, 36, 3.00, false, true, true),

    (044525823, 'Газпромбанк Вклад "В Плюсе", без привилегий', 'https://www.gazprombank.ru/personal/increase/deposits/detail/7476877/', true, 643, 15000, 100000000, 1, 13.50, false, false, false),
    (044525823, 'Газпромбанк Вклад "В Плюсе", без привилегий', 'https://www.gazprombank.ru/personal/increase/deposits/detail/7476877/', true, 643, 15000, 100000000, 3, 13.74, false, false, false),
    (044525823, 'Газпромбанк Вклад "В Плюсе", без привилегий', 'https://www.gazprombank.ru/personal/increase/deposits/detail/7476877/', true, 643, 15000, 100000000, 4, 13.66, false, false, false),
    (044525823, 'Газпромбанк Вклад "В Плюсе", без привилегий', 'https://www.gazprombank.ru/personal/increase/deposits/detail/7476877/', true, 643, 15000, 100000000, 6, 14.50, false, false, false),
    (044525823, 'Газпромбанк Вклад "В Плюсе", без привилегий', 'https://www.gazprombank.ru/personal/increase/deposits/detail/7476877/', true, 643, 15000, 100000000, 12, 11.34, false, false, false),
    (044525823, 'Газпромбанк Вклад "В Плюсе", без привилегий', 'https://www.gazprombank.ru/personal/increase/deposits/detail/7476877/', true, 643, 15000, 100000000, 24, 7.63, false, false, false),
    (044525823, 'Газпромбанк Вклад "В Плюсе", без привилегий', 'https://www.gazprombank.ru/personal/increase/deposits/detail/7476877/', true, 643, 15000, 100000000, 36, 10.53, false, false, false),

    (044525823, 'Газпромбанк Вклад "В Плюсе", без привилегий', 'https://www.gazprombank.ru/personal/increase/deposits/detail/7476877/', true, 643, 15000, 100000000, 1, 13.50, true, false, false),
    (044525823, 'Газпромбанк Вклад "В Плюсе", без привилегий', 'https://www.gazprombank.ru/personal/increase/deposits/detail/7476877/', true, 643, 15000, 100000000, 3, 13.90, true, false, false),
    (044525823, 'Газпромбанк Вклад "В Плюсе", без привилегий', 'https://www.gazprombank.ru/personal/increase/deposits/detail/7476877/', true, 643, 15000, 100000000, 4, 13.89, true, false, false),
    (044525823, 'Газпромбанк Вклад "В Плюсе", без привилегий', 'https://www.gazprombank.ru/personal/increase/deposits/detail/7476877/', true, 643, 15000, 100000000, 6, 14.94, true, false, false),
    (044525823, 'Газпромбанк Вклад "В Плюсе", без привилегий', 'https://www.gazprombank.ru/personal/increase/deposits/detail/7476877/', true, 643, 15000, 100000000, 12, 11.95, true, false, false),
    (044525823, 'Газпромбанк Вклад "В Плюсе", без привилегий', 'https://www.gazprombank.ru/personal/increase/deposits/detail/7476877/', true, 643, 15000, 100000000, 24, 8.22, true, false, false),
    (044525823, 'Газпромбанк Вклад "В Плюсе", без привилегий', 'https://www.gazprombank.ru/personal/increase/deposits/detail/7476877/', true, 643, 15000, 100000000, 36, 12.32, true, false, false),

    (044525823, 'Газпромбанк Вклад "Копить", для всех', 'https://www.gazprombank.ru/personal/increase/deposits/detail/2491/', true, 643, 15000, 100000000, 1, 13.80, false, false, false),
    (044525823, 'Газпромбанк Вклад "Копить", для всех', 'https://www.gazprombank.ru/personal/increase/deposits/detail/2491/', true, 643, 15000, 100000000, 3, 14.04, false, false, false),
    (044525823, 'Газпромбанк Вклад "Копить", для всех', 'https://www.gazprombank.ru/personal/increase/deposits/detail/2491/', true, 643, 15000, 100000000, 4, 13.96, false, false, false),
    (044525823, 'Газпромбанк Вклад "Копить", для всех', 'https://www.gazprombank.ru/personal/increase/deposits/detail/2491/', true, 643, 15000, 100000000, 6, 14.83, false, false, false),
    (044525823, 'Газпромбанк Вклад "Копить", для всех', 'https://www.gazprombank.ru/personal/increase/deposits/detail/2491/', true, 643, 15000, 100000000, 12, 11.64, false, false, false),
    (044525823, 'Газпромбанк Вклад "Копить", для всех', 'https://www.gazprombank.ru/personal/increase/deposits/detail/2491/', true, 643, 15000, 100000000, 24, 7.93, false, false, false),
    (044525823, 'Газпромбанк Вклад "Копить", для всех', 'https://www.gazprombank.ru/personal/increase/deposits/detail/2491/', true, 643, 15000, 100000000, 36, 10.83, false, false, false),

    (044525823, 'Газпромбанк Вклад "Копить", для всех', 'https://www.gazprombank.ru/personal/increase/deposits/detail/2491/', true, 643, 15000, 100000000, 1, 13.80, true, false, false),
    (044525823, 'Газпромбанк Вклад "Копить", для всех', 'https://www.gazprombank.ru/personal/increase/deposits/detail/2491/', true, 643, 15000, 100000000, 3, 14.20, true, false, false),
    (044525823, 'Газпромбанк Вклад "Копить", для всех', 'https://www.gazprombank.ru/personal/increase/deposits/detail/2491/', true, 643, 15000, 100000000, 4, 14.20, true, false, false),
    (044525823, 'Газпромбанк Вклад "Копить", для всех', 'https://www.gazprombank.ru/personal/increase/deposits/detail/2491/', true, 643, 15000, 100000000, 6, 15.29, true, false, false),
    (044525823, 'Газпромбанк Вклад "Копить", для всех', 'https://www.gazprombank.ru/personal/increase/deposits/detail/2491/', true, 643, 15000, 100000000, 12, 12.29, true, false, false),
    (044525823, 'Газпромбанк Вклад "Копить", для всех', 'https://www.gazprombank.ru/personal/increase/deposits/detail/2491/', true, 643, 15000, 100000000, 24, 8.56, true, false, false),
    (044525823, 'Газпромбанк Вклад "Копить", для всех', 'https://www.gazprombank.ru/personal/increase/deposits/detail/2491/', true, 643, 15000, 100000000, 36, 12.73, true, false, false);

INSERT INTO credits (bank_bic, name, product_url, is_active, currency_num, amount_min, amount_max, term, rate)
VALUES
    (044525823, 'credit-1%', 'credit-1%-url', true, 643, 10000, 1000000, 12, 1.0),
    (044525823, 'credit-3%', 'credit-3%-url', true, 643, 10000, 1000000, 12, 3.0);
