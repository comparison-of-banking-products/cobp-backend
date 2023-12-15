INSERT INTO banks (bic, name, legal_entity, description, logo, url)
VALUES
    (1, 'ban4ok-1', 'ban4ok-1-legalnyy', 'dlya vas svezhenkiy tovarchik, a dlya nas - solidnyy navarchik', 'ban4ok-1-logo', 'ban4ok-1-url'),
    (2, 'ban4ok-2', 'ban4ok-2-legalnyy', 'u kogo net nalichnykh, budet rydat neprilichno', 'ban4ok-2-logo', 'ban4ok-2-url');

INSERT INTO currencies (num, code, currency)
VALUES (643, 'RUB', 'Russian ruble');

INSERT INTO deposits (bank_bic, name, product_url, is_active, currency_num, amount_min, amount_max, term, rate)
VALUES
    (1, 'deposit-5%', 'deposit-5%-url', true, 643, 10000, 1000000, 12, 5.0),
    (2, 'deposit-7%', 'deposit-7%-url', true, 643, 10000, 1000000, 12, 7.0);

INSERT INTO credits (bank_bic, name, product_url, is_active, currency_num, amount_min, amount_max, term, rate)
VALUES
    (1, 'credit-1%', 'credit-1%-url', true, 643, 10000, 1000000, 12, 1.0),
    (2, 'credit-3%', 'credit-3%-url', true, 643, 10000, 1000000, 12, 3.0);
