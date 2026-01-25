-- ============================================================
-- INSERT SAMPLE DATA
-- ============================================================

-- Insert users
INSERT INTO users (username, password, role) VALUES 
('kasir001', 'pass123', 'KASIR'),
('kasir002', 'pass123', 'KASIR'),
('admin001', 'admin123', 'ADMIN');

-- Insert products (seed data)
INSERT INTO products (code, name, category, price, stock) VALUES 
('BNH-001', 'Benih Padi Premium', 'Benih', 25000.00, 150),
('BNH-002', 'Benih Jagung Hibrida', 'Benih', 30000.00, 120),
('BNH-003', 'Benih Cabai Keriting', 'Benih', 45000.00, 80),
('PES-001', 'Pupuk Urea 50kg', 'Pupuk', 150000.00, 80),
('PES-002', 'Pupuk NPK 50kg', 'Pupuk', 180000.00, 60),
('OBT-001', 'Insektisida Organik 1L', 'Obat Tanaman', 65000.00, 40),
('OBT-002', 'Fungisida Organik 1L', 'Obat Tanaman', 75000.00, 35),
('ALT-001', 'Hand Sprayer 5L', 'Alat', 85000.00, 25),
('ALT-002', 'Cangkul Standar', 'Alat', 45000.00, 50),
('ALT-003', 'Selang 20m', 'Alat', 120000.00, 15);

-- ============================================================
-- INSERT SAMPLE TRANSACTIONS
-- ============================================================

-- Transaction 1: Kasir001 - Transaksi pagi hari
INSERT INTO transactions (date, total, payment_method, status, created_by) VALUES 
(CURRENT_TIMESTAMP - INTERVAL '2 days', 175000.00, 'CASH', 'COMPLETED', 1),
(CURRENT_TIMESTAMP - INTERVAL '2 days', 225000.00, 'EWALLET', 'COMPLETED', 1),
(CURRENT_TIMESTAMP - INTERVAL '1 days', 305000.00, 'CASH', 'COMPLETED', 1),
(CURRENT_TIMESTAMP - INTERVAL '1 days', 150000.00, 'EWALLET', 'COMPLETED', 2),
(CURRENT_TIMESTAMP - INTERVAL '1 days', 435000.00, 'CASH', 'COMPLETED', 2),
(CURRENT_TIMESTAMP, 185000.00, 'CASH', 'COMPLETED', 1),
(CURRENT_TIMESTAMP, 240000.00, 'EWALLET', 'COMPLETED', 2),
(CURRENT_TIMESTAMP, 380000.00, 'CASH', 'COMPLETED', 1);

-- ============================================================
-- INSERT SAMPLE TRANSACTION ITEMS
-- ============================================================

-- Transaction 1 Items: 2 Benih Padi + 3 Pupuk Urea = 25000*2 + 150000*1 = 200000
-- Adjusted to 175000
INSERT INTO transaction_items (transaction_id, product_id, quantity, price) VALUES 
(1, 1, 2, 25000.00),      -- 2x Benih Padi = 50000
(1, 4, 1, 125000.00);     -- 1x Pupuk Urea (harga bervariasi) = 125000

-- Transaction 2 Items: 1 Pupuk NPK + 2 Obat Tanaman
INSERT INTO transaction_items (transaction_id, product_id, quantity, price) VALUES 
(2, 5, 1, 150000.00),     -- 1x Pupuk NPK = 150000
(2, 6, 1, 75000.00);      -- 1x Insektisida = 75000

-- Transaction 3 Items: 1 Hand Sprayer + 2 Benih Cabai + 3 Benih Jagung
INSERT INTO transaction_items (transaction_id, product_id, quantity, price) VALUES 
(3, 8, 1, 85000.00),      -- 1x Hand Sprayer = 85000
(3, 3, 2, 45000.00),      -- 2x Benih Cabai = 90000
(3, 2, 3, 30000.00);      -- 3x Benih Jagung = 90000

-- Transaction 4 Items: 1 Cangkul + 1 Benih Padi
INSERT INTO transaction_items (transaction_id, product_id, quantity, price) VALUES 
(4, 9, 1, 45000.00),      -- 1x Cangkul = 45000
(4, 1, 4, 25000.00);      -- 4x Benih Padi = 100000

-- Transaction 5 Items: 2 Selang + 1 Pupuk NPK + 2 Fungisida
INSERT INTO transaction_items (transaction_id, product_id, quantity, price) VALUES 
(5, 10, 2, 120000.00),    -- 2x Selang = 240000
(5, 5, 1, 180000.00),     -- 1x Pupuk NPK = 180000
(5, 7, 1, 15000.00);      -- Extra items adjustment = 15000

-- Transaction 6 Items: 1 Benih Cabai + 1 Obat Tanaman
INSERT INTO transaction_items (transaction_id, product_id, quantity, price) VALUES 
(6, 3, 2, 45000.00),      -- 2x Benih Cabai = 90000
(6, 6, 1, 65000.00),      -- 1x Insektisida = 65000
(6, 1, 1, 30000.00);      -- 1x Benih Padi = 30000

-- Transaction 7 Items: 1 Pupuk + 2 Benih Jagung
INSERT INTO transaction_items (transaction_id, product_id, quantity, price) VALUES 
(7, 4, 1, 150000.00),     -- 1x Pupuk Urea = 150000
(7, 2, 3, 30000.00);      -- 3x Benih Jagung = 90000

-- Transaction 8 Items: 1 Cangkul + 1 Hand Sprayer + Benih mix
INSERT INTO transaction_items (transaction_id, product_id, quantity, price) VALUES 
(8, 9, 2, 45000.00),      -- 2x Cangkul = 90000
(8, 8, 1, 85000.00),      -- 1x Hand Sprayer = 85000
(8, 3, 3, 45000.00),      -- 3x Benih Cabai = 135000
(8, 1, 1, 25000.00);      -- 1x Benih Padi = 25000

-- ============================================================
-- VERIFICATION QUERIES (Run these to check data)
-- ============================================================
-- SELECT COUNT(*) as total_transactions FROM transactions;
-- SELECT COUNT(*) as total_items FROM transaction_items;
-- SELECT t.id, t.total, t.payment_method, COUNT(ti.id) as item_count 
-- FROM transactions t LEFT JOIN transaction_items ti ON t.id = ti.transaction_id 
-- GROUP BY t.id, t.total, t.payment_method;