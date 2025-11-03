INSERT INTO category(code, name)
SELECT format('CAT%04s', gs), format('Category %s', gs)
FROM generate_series(1, 2000) AS gs;

INSERT INTO item(category_id, sku, label, description, price, stock)
SELECT 
  ((gs-1) % 2000) + 1,
  format('SKU%06s', gs),
  format('Item %s', gs),
  repeat('Lorem ipsum ', (random()*10)::int + 5),
  round((random()*1000)::numeric, 2),
  (random()*100)::int
FROM generate_series(1, 100000) AS gs;
