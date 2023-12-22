INSERT INTO banks (bic, name, legal_entity, description, logo, url)
VALUES
    (044525974, 'Тинькофф Банк', 'АО "Тинькофф Банк"', 'Онлайн-экосистема, основанная на финансовых и лайфстайл-услугах', 'tinkoff-logo.svg', 'https://www.tinkoff.ru'),
    (044525187, 'Банк ВТБ', 'ПАО "Банк ВТБ"', 'Системообразующий универсальный российский банк', 'vtb-logo.svg', 'https://www.vtb.ru'),
    (044525823, 'Газпромбанк', 'АО "Газпромбанк"', 'Один из крупнейших универсальных финансовых институтов России', 'gazprombank-logo.svg', 'https://www.gazprombank.ru'),
    (044525593, 'Альфа-Банк', 'АО "Альфа-Банк"', 'Крупнейший частный банк в России', 'alfabank-logo.svg', 'https://alfabank.ru'),
    (044525111, 'Россельхозбанк', 'АО "Российский Cельскохозяйственный банк"', 'Универсальный коммерческий банк, лидер в финансировании агропромышленного комплекса России', 'rshb-logo.svg', 'https://www.rshb.ru'),
    (044525225, 'Сбербанк', 'ПАО "Сбербанк России"', 'Российский финансовый конгломерат, крупнейший универсальный банк', 'sberbank-logo.svg', 'https://www.sberbank.ru');

INSERT INTO currencies (num, code, currency)
VALUES
    (156, 'CNY', 'Китайский юань'),
    (392, 'JPY', 'Японская иена'),
    (643, 'RUB', 'Российский рубль'),
    (756, 'CHF', 'Швейцарский франк'),
    (826, 'GBP', 'Фунт стерлингов'),
    (840, 'USD', 'Доллар США'),
    (978, 'EUR', 'Евро');

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

INSERT INTO credits (bank_bic, name, product_url, is_active, currency_num, amount_min, amount_max, term, rate, payment_type)
VALUES
    (044525974, 'Тинькофф Кредит наличными, без залога', 'https://www.tinkoff.ru/loans/cash-loan/', true, 643, 50000, 5000000, 3, 50.00, 1),
    (044525974, 'Тинькофф Кредит наличными, без залога', 'https://www.tinkoff.ru/loans/cash-loan/', true, 643, 50000, 5000000, 6, 43.15, 0),
    (044525974, 'Тинькофф Кредит наличными, без залога', 'https://www.tinkoff.ru/loans/cash-loan/', true, 643, 50000, 5000000, 12, 36.30, 0),
    (044525974, 'Тинькофф Кредит наличными, без залога', 'https://www.tinkoff.ru/loans/cash-loan/', true, 643, 50000, 5000000, 24, 29.45, 0),
    (044525974, 'Тинькофф Кредит наличными, без залога', 'https://www.tinkoff.ru/loans/cash-loan/', true, 643, 50000, 5000000, 36, 22.60, 0),
    (044525974, 'Тинькофф Кредит наличными, без залога', 'https://www.tinkoff.ru/loans/cash-loan/', true, 643, 50000, 5000000, 48, 15.75, 0),
    (044525974, 'Тинькофф Кредит наличными, без залога', 'https://www.tinkoff.ru/loans/cash-loan/', true, 643, 50000, 5000000, 60, 8.90, 0),

    (044525187, 'ВТБ Кредит наличными, без заключения договора страхования, без услуги "Ваша низкая ставка"', 'https://www.vtb.ru/personal/kredit/nalichnymi/', true, 643, 30000, 100000, 6, 51.20, 1),
    (044525187, 'ВТБ Кредит наличными, без заключения договора страхования, без услуги "Ваша низкая ставка"', 'https://www.vtb.ru/personal/kredit/nalichnymi/', true, 643, 30000, 100000, 12, 45.34, 0),
    (044525187, 'ВТБ Кредит наличными, без заключения договора страхования, без услуги "Ваша низкая ставка"', 'https://www.vtb.ru/personal/kredit/nalichnymi/', true, 643, 30000, 100000, 24, 39.48, 0),
    (044525187, 'ВТБ Кредит наличными, без заключения договора страхования, без услуги "Ваша низкая ставка"', 'https://www.vtb.ru/personal/kredit/nalichnymi/', true, 643, 30000, 100000, 36, 33.62, 0),
    (044525187, 'ВТБ Кредит наличными, без заключения договора страхования, без услуги "Ваша низкая ставка"', 'https://www.vtb.ru/personal/kredit/nalichnymi/', true, 643, 30000, 100000, 48, 27.76, 0),
    (044525187, 'ВТБ Кредит наличными, без заключения договора страхования, без услуги "Ваша низкая ставка"', 'https://www.vtb.ru/personal/kredit/nalichnymi/', true, 643, 30000, 100000, 60, 21.90, 0),

    (044525187, 'ВТБ Кредит наличными, без заключения договора страхования, без услуги "Ваша низкая ставка"', 'https://www.vtb.ru/personal/kredit/nalichnymi/', true, 643, 100001, 299999, 6, 44.20, 1),
    (044525187, 'ВТБ Кредит наличными, без заключения договора страхования, без услуги "Ваша низкая ставка"', 'https://www.vtb.ru/personal/kredit/nalichnymi/', true, 643, 100001, 299999, 12, 38.62, 0),
    (044525187, 'ВТБ Кредит наличными, без заключения договора страхования, без услуги "Ваша низкая ставка"', 'https://www.vtb.ru/personal/kredit/nalichnymi/', true, 643, 100001, 299999, 24, 33.04, 0),
    (044525187, 'ВТБ Кредит наличными, без заключения договора страхования, без услуги "Ваша низкая ставка"', 'https://www.vtb.ru/personal/kredit/nalichnymi/', true, 643, 100001, 299999, 36, 27.46, 0),
    (044525187, 'ВТБ Кредит наличными, без заключения договора страхования, без услуги "Ваша низкая ставка"', 'https://www.vtb.ru/personal/kredit/nalichnymi/', true, 643, 100001, 299999, 48, 21.88, 0),
    (044525187, 'ВТБ Кредит наличными, без заключения договора страхования, без услуги "Ваша низкая ставка"', 'https://www.vtb.ru/personal/kredit/nalichnymi/', true, 643, 100001, 299999, 60, 16.30, 0),

    (044525187, 'ВТБ Кредит наличными, без заключения договора страхования, без услуги "Ваша низкая ставка"', 'https://www.vtb.ru/personal/kredit/nalichnymi/', true, 643, 300000, 999999, 6, 39.20, 1),
    (044525187, 'ВТБ Кредит наличными, без заключения договора страхования, без услуги "Ваша низкая ставка"', 'https://www.vtb.ru/personal/kredit/nalichnymi/', true, 643, 300000, 999999, 12, 34.62, 0),
    (044525187, 'ВТБ Кредит наличными, без заключения договора страхования, без услуги "Ваша низкая ставка"', 'https://www.vtb.ru/personal/kredit/nalichnymi/', true, 643, 300000, 999999, 24, 30.04, 0),
    (044525187, 'ВТБ Кредит наличными, без заключения договора страхования, без услуги "Ваша низкая ставка"', 'https://www.vtb.ru/personal/kredit/nalichnymi/', true, 643, 300000, 999999, 36, 25.46, 0),
    (044525187, 'ВТБ Кредит наличными, без заключения договора страхования, без услуги "Ваша низкая ставка"', 'https://www.vtb.ru/personal/kredit/nalichnymi/', true, 643, 300000, 999999, 48, 20.88, 0),
    (044525187, 'ВТБ Кредит наличными, без заключения договора страхования, без услуги "Ваша низкая ставка"', 'https://www.vtb.ru/personal/kredit/nalichnymi/', true, 643, 300000, 999999, 60, 16.30, 0),

    (044525187, 'ВТБ Кредит наличными, без заключения договора страхования, без услуги "Ваша низкая ставка"', 'https://www.vtb.ru/personal/kredit/nalichnymi/', true, 643, 1000000, 7000000, 6, 39.20, 1),
    (044525187, 'ВТБ Кредит наличными, без заключения договора страхования, без услуги "Ваша низкая ставка"', 'https://www.vtb.ru/personal/kredit/nalichnymi/', true, 643, 1000000, 7000000, 12, 34.22, 0),
    (044525187, 'ВТБ Кредит наличными, без заключения договора страхования, без услуги "Ваша низкая ставка"', 'https://www.vtb.ru/personal/kredit/nalichnymi/', true, 643, 1000000, 7000000, 24, 29.24, 0),
    (044525187, 'ВТБ Кредит наличными, без заключения договора страхования, без услуги "Ваша низкая ставка"', 'https://www.vtb.ru/personal/kredit/nalichnymi/', true, 643, 1000000, 7000000, 36, 24.26, 0),
    (044525187, 'ВТБ Кредит наличными, без заключения договора страхования, без услуги "Ваша низкая ставка"', 'https://www.vtb.ru/personal/kredit/nalichnymi/', true, 643, 1000000, 7000000, 48, 19.28, 0),
    (044525187, 'ВТБ Кредит наличными, без заключения договора страхования, без услуги "Ваша низкая ставка"', 'https://www.vtb.ru/personal/kredit/nalichnymi/', true, 643, 1000000, 7000000, 60, 14.30, 0),

    (044525187, 'ВТБ Кредит наличными, без заключения договора страхования, без услуги "Ваша низкая ставка"', 'https://www.vtb.ru/personal/kredit/nalichnymi/', true, 643, 7000001, 40000000, 6, 39.20, 1),
    (044525187, 'ВТБ Кредит наличными, без заключения договора страхования, без услуги "Ваша низкая ставка"', 'https://www.vtb.ru/personal/kredit/nalichnymi/', true, 643, 7000001, 40000000, 12, 34.18, 0),
    (044525187, 'ВТБ Кредит наличными, без заключения договора страхования, без услуги "Ваша низкая ставка"', 'https://www.vtb.ru/personal/kredit/nalichnymi/', true, 643, 7000001, 40000000, 24, 29.16, 0),
    (044525187, 'ВТБ Кредит наличными, без заключения договора страхования, без услуги "Ваша низкая ставка"', 'https://www.vtb.ru/personal/kredit/nalichnymi/', true, 643, 7000001, 40000000, 36, 24.14, 0),
    (044525187, 'ВТБ Кредит наличными, без заключения договора страхования, без услуги "Ваша низкая ставка"', 'https://www.vtb.ru/personal/kredit/nalichnymi/', true, 643, 7000001, 40000000, 48, 19.12, 0),
    (044525187, 'ВТБ Кредит наличными, без заключения договора страхования, без услуги "Ваша низкая ставка"', 'https://www.vtb.ru/personal/kredit/nalichnymi/', true, 643, 7000001, 40000000, 60, 14.10, 0),

    (044525823, 'Газпромбанк Кредит наличными', 'https://www.gazprombank.ru/personal/take_credit/consumer_credit/5004451/', true, 643, 10000, 7000000, 13, 24.40, 1),
    (044525823, 'Газпромбанк Кредит наличными', 'https://www.gazprombank.ru/personal/take_credit/consumer_credit/5004451/', true, 643, 10000, 7000000, 24, 20.98, 0),
    (044525823, 'Газпромбанк Кредит наличными', 'https://www.gazprombank.ru/personal/take_credit/consumer_credit/5004451/', true, 643, 10000, 7000000, 36, 17.56, 0),
    (044525823, 'Газпромбанк Кредит наличными', 'https://www.gazprombank.ru/personal/take_credit/consumer_credit/5004451/', true, 643, 10000, 7000000, 48, 14.15, 0),
    (044525823, 'Газпромбанк Кредит наличными', 'https://www.gazprombank.ru/personal/take_credit/consumer_credit/5004451/', true, 643, 10000, 7000000, 60, 10.73, 0),
    (044525823, 'Газпромбанк Кредит наличными', 'https://www.gazprombank.ru/personal/take_credit/consumer_credit/5004451/', true, 643, 10000, 7000000, 72, 7.32, 0),
    (044525823, 'Газпромбанк Кредит наличными', 'https://www.gazprombank.ru/personal/take_credit/consumer_credit/5004451/', true, 643, 10000, 7000000, 84, 3.90, 0),

    (044525593, 'Альфа-банк Кредит наличными', 'https://alfabank.ru/get-money/credit/credit-cash/', true, 643, 100000, 15000000, 12, 34.99, 1),
    (044525593, 'Альфа-банк Кредит наличными', 'https://alfabank.ru/get-money/credit/credit-cash/', true, 643, 100000, 15000000, 24, 31.55, 0),
    (044525593, 'Альфа-банк Кредит наличными', 'https://alfabank.ru/get-money/credit/credit-cash/', true, 643, 100000, 15000000, 36, 28.10, 0),
    (044525593, 'Альфа-банк Кредит наличными', 'https://alfabank.ru/get-money/credit/credit-cash/', true, 643, 100000, 15000000, 48, 24.66, 0),
    (044525593, 'Альфа-банк Кредит наличными', 'https://alfabank.ru/get-money/credit/credit-cash/', true, 643, 100000, 15000000, 60, 21.22, 0),
    (044525593, 'Альфа-банк Кредит наличными', 'https://alfabank.ru/get-money/credit/credit-cash/', true, 643, 100000, 15000000, 72, 17.77, 0),
    (044525593, 'Альфа-банк Кредит наличными', 'https://alfabank.ru/get-money/credit/credit-cash/', true, 643, 100000, 15000000, 84, 14.33, 0),
    (044525593, 'Альфа-банк Кредит наличными', 'https://alfabank.ru/get-money/credit/credit-cash/', true, 643, 100000, 15000000, 96, 10.89, 0),
    (044525593, 'Альфа-банк Кредит наличными', 'https://alfabank.ru/get-money/credit/credit-cash/', true, 643, 100000, 15000000, 108, 7.44, 0),
    (044525593, 'Альфа-банк Кредит наличными', 'https://alfabank.ru/get-money/credit/credit-cash/', true, 643, 100000, 15000000, 120, 4.00, 0),

    (044525111, 'Россельхозбанк Кредит без залога и поручительства, иные физические лица', 'https://www.rshb.ru/natural/loans/all-goals', true, 643, 30000, 299999, 13, 21.50, 1),
    (044525111, 'Россельхозбанк Кредит без залога и поручительства, иные физические лица', 'https://www.rshb.ru/natural/loans/all-goals', true, 643, 30000, 299999, 24, 20.15, 0),
    (044525111, 'Россельхозбанк Кредит без залога и поручительства, иные физические лица', 'https://www.rshb.ru/natural/loans/all-goals', true, 643, 30000, 299999, 36, 18.80, 0),
    (044525111, 'Россельхозбанк Кредит без залога и поручительства, иные физические лица', 'https://www.rshb.ru/natural/loans/all-goals', true, 643, 30000, 299999, 48, 17.45, 0),
    (044525111, 'Россельхозбанк Кредит без залога и поручительства, иные физические лица', 'https://www.rshb.ru/natural/loans/all-goals', true, 643, 30000, 299999, 60, 16.10, 0),

    (044525111, 'Россельхозбанк Кредит без залога и поручительства, иные физические лица', 'https://www.rshb.ru/natural/loans/all-goals', true, 643, 300000, 999999, 13, 18.50, 1),
    (044525111, 'Россельхозбанк Кредит без залога и поручительства, иные физические лица', 'https://www.rshb.ru/natural/loans/all-goals', true, 643, 300000, 999999, 24, 17.90, 0),
    (044525111, 'Россельхозбанк Кредит без залога и поручительства, иные физические лица', 'https://www.rshb.ru/natural/loans/all-goals', true, 643, 300000, 999999, 36, 17.30, 0),
    (044525111, 'Россельхозбанк Кредит без залога и поручительства, иные физические лица', 'https://www.rshb.ru/natural/loans/all-goals', true, 643, 300000, 999999, 48, 16.70, 0),
    (044525111, 'Россельхозбанк Кредит без залога и поручительства, иные физические лица', 'https://www.rshb.ru/natural/loans/all-goals', true, 643, 300000, 999999, 60, 16.10, 0),

    (044525111, 'Россельхозбанк Кредит без залога и поручительства, иные физические лица', 'https://www.rshb.ru/natural/loans/all-goals', true, 643, 1000000, 2499999, 13, 18.50, 1),
    (044525111, 'Россельхозбанк Кредит без залога и поручительства, иные физические лица', 'https://www.rshb.ru/natural/loans/all-goals', true, 643, 1000000, 2499999, 24, 17.75, 0),
    (044525111, 'Россельхозбанк Кредит без залога и поручительства, иные физические лица', 'https://www.rshb.ru/natural/loans/all-goals', true, 643, 1000000, 2499999, 36, 17.00, 0),
    (044525111, 'Россельхозбанк Кредит без залога и поручительства, иные физические лица', 'https://www.rshb.ru/natural/loans/all-goals', true, 643, 1000000, 2499999, 48, 16.25, 0),
    (044525111, 'Россельхозбанк Кредит без залога и поручительства, иные физические лица', 'https://www.rshb.ru/natural/loans/all-goals', true, 643, 1000000, 2499999, 60, 15.50, 0),

    (044525111, 'Россельхозбанк Кредит без залога и поручительства, иные физические лица', 'https://www.rshb.ru/natural/loans/all-goals', true, 643, 2500000, 5000000, 13, 16.50, 1),
    (044525111, 'Россельхозбанк Кредит без залога и поручительства, иные физические лица', 'https://www.rshb.ru/natural/loans/all-goals', true, 643, 2500000, 5000000, 24, 16.25, 0),
    (044525111, 'Россельхозбанк Кредит без залога и поручительства, иные физические лица', 'https://www.rshb.ru/natural/loans/all-goals', true, 643, 2500000, 5000000, 36, 16.00, 0),
    (044525111, 'Россельхозбанк Кредит без залога и поручительства, иные физические лица', 'https://www.rshb.ru/natural/loans/all-goals', true, 643, 2500000, 5000000, 48, 17.75, 0),
    (044525111, 'Россельхозбанк Кредит без залога и поручительства, иные физические лица', 'https://www.rshb.ru/natural/loans/all-goals', true, 643, 2500000, 5000000, 60, 15.50, 0),

    (044525225, 'Сбербанк Кредит на любые цели, общие условия', 'https://www.sberbank.com/ru/person/credits/money/consumer_unsecured', true, 643, 10000, 299999, 3, 34.90, 1),
    (044525225, 'Сбербанк Кредит на любые цели, общие условия', 'https://www.sberbank.com/ru/person/credits/money/consumer_unsecured', true, 643, 10000, 299999, 6, 33.00, 0),
    (044525225, 'Сбербанк Кредит на любые цели, общие условия', 'https://www.sberbank.com/ru/person/credits/money/consumer_unsecured', true, 643, 10000, 299999, 9, 31.05, 0),
    (044525225, 'Сбербанк Кредит на любые цели, общие условия', 'https://www.sberbank.com/ru/person/credits/money/consumer_unsecured', true, 643, 10000, 299999, 12, 29.13, 0),
    (044525225, 'Сбербанк Кредит на любые цели, общие условия', 'https://www.sberbank.com/ru/person/credits/money/consumer_unsecured', true, 643, 10000, 299999, 13, 27.20, 0),
    (044525225, 'Сбербанк Кредит на любые цели, общие условия', 'https://www.sberbank.com/ru/person/credits/money/consumer_unsecured', true, 643, 10000, 299999, 24, 25.28, 0),
    (044525225, 'Сбербанк Кредит на любые цели, общие условия', 'https://www.sberbank.com/ru/person/credits/money/consumer_unsecured', true, 643, 10000, 299999, 36, 23.35, 0),
    (044525225, 'Сбербанк Кредит на любые цели, общие условия', 'https://www.sberbank.com/ru/person/credits/money/consumer_unsecured', true, 643, 10000, 299999, 48, 21.43, 0),
    (044525225, 'Сбербанк Кредит на любые цели, общие условия', 'https://www.sberbank.com/ru/person/credits/money/consumer_unsecured', true, 643, 10000, 299999, 60, 19.50, 0),

    (044525225, 'Сбербанк Кредит на любые цели, общие условия', 'https://www.sberbank.com/ru/person/credits/money/consumer_unsecured', true, 643, 300000, 999999, 3, 27.90, 1),
    (044525225, 'Сбербанк Кредит на любые цели, общие условия', 'https://www.sberbank.com/ru/person/credits/money/consumer_unsecured', true, 643, 300000, 999999, 6, 26.60, 0),
    (044525225, 'Сбербанк Кредит на любые цели, общие условия', 'https://www.sberbank.com/ru/person/credits/money/consumer_unsecured', true, 643, 300000, 999999, 9, 25.30, 0),
    (044525225, 'Сбербанк Кредит на любые цели, общие условия', 'https://www.sberbank.com/ru/person/credits/money/consumer_unsecured', true, 643, 300000, 999999, 12, 24.00, 0),
    (044525225, 'Сбербанк Кредит на любые цели, общие условия', 'https://www.sberbank.com/ru/person/credits/money/consumer_unsecured', true, 643, 300000, 999999, 13, 22.70, 0),
    (044525225, 'Сбербанк Кредит на любые цели, общие условия', 'https://www.sberbank.com/ru/person/credits/money/consumer_unsecured', true, 643, 300000, 999999, 24, 21.40, 0),
    (044525225, 'Сбербанк Кредит на любые цели, общие условия', 'https://www.sberbank.com/ru/person/credits/money/consumer_unsecured', true, 643, 300000, 999999, 36, 20.10, 0),
    (044525225, 'Сбербанк Кредит на любые цели, общие условия', 'https://www.sberbank.com/ru/person/credits/money/consumer_unsecured', true, 643, 300000, 999999, 48, 18.80, 0),
    (044525225, 'Сбербанк Кредит на любые цели, общие условия', 'https://www.sberbank.com/ru/person/credits/money/consumer_unsecured', true, 643, 300000, 999999, 60, 17.50, 0),

    (044525225, 'Сбербанк Кредит на любые цели, общие условия', 'https://www.sberbank.com/ru/person/credits/money/consumer_unsecured', true, 643, 1000000, 30000000, 3, 24.90, 1),
    (044525225, 'Сбербанк Кредит на любые цели, общие условия', 'https://www.sberbank.com/ru/person/credits/money/consumer_unsecured', true, 643, 1000000, 30000000, 6, 23.90, 0),
    (044525225, 'Сбербанк Кредит на любые цели, общие условия', 'https://www.sberbank.com/ru/person/credits/money/consumer_unsecured', true, 643, 1000000, 30000000, 9, 22.90, 0),
    (044525225, 'Сбербанк Кредит на любые цели, общие условия', 'https://www.sberbank.com/ru/person/credits/money/consumer_unsecured', true, 643, 1000000, 30000000, 12, 21.90, 0),
    (044525225, 'Сбербанк Кредит на любые цели, общие условия', 'https://www.sberbank.com/ru/person/credits/money/consumer_unsecured', true, 643, 1000000, 30000000, 13, 20.90, 0),
    (044525225, 'Сбербанк Кредит на любые цели, общие условия', 'https://www.sberbank.com/ru/person/credits/money/consumer_unsecured', true, 643, 1000000, 30000000, 24, 19.90, 0),
    (044525225, 'Сбербанк Кредит на любые цели, общие условия', 'https://www.sberbank.com/ru/person/credits/money/consumer_unsecured', true, 643, 1000000, 30000000, 36, 18.90, 0),
    (044525225, 'Сбербанк Кредит на любые цели, общие условия', 'https://www.sberbank.com/ru/person/credits/money/consumer_unsecured', true, 643, 1000000, 30000000, 48, 17.90, 0),
    (044525225, 'Сбербанк Кредит на любые цели, общие условия', 'https://www.sberbank.com/ru/person/credits/money/consumer_unsecured', true, 643, 1000000, 30000000, 60, 16.90, 0);
