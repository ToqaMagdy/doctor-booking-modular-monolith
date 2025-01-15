CREATE TABLE IF NOT EXISTS public.slot
(
    id uuid NOT NULL,
    "time" date,
    doctor_id uuid NOT NULL,
    doctor_name character varying(100) COLLATE pg_catalog."default",
    is_reserved boolean DEFAULT false,
    cost double precision,
    CONSTRAINT slot_pkey PRIMARY KEY (id)
    )