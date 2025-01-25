-- Insert dummy data into the doctors table
INSERT INTO public.doctors (id, name) VALUES
('11111111-1111-1111-1111-111111111111', 'Dr. John Doe');

-- Insert dummy data into the slots table
INSERT INTO public.slots (id, doctor_name, time, doctor_id, is_reserved, cost) VALUES
('33333333-3333-3333-3333-333333333333', 'Dr. John Doe', '2023-12-01 10:00 AM', '11111111-1111-1111-1111-111111111111', false, 100.0),
('44444444-4444-4444-4444-444444444444', 'Dr. John Doe', '2023-12-02 11:00 PM', '11111111-1111-1111-1111-111111111111', true, 150.0);