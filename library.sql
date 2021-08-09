BEGIN;


CREATE TABLE public.book
(
    id integer NOT NULL GENERATED BY DEFAULT AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    book_title character varying(50) NOT NULL,
    book_author character varying(50) NOT NULL,
    first_publish_date date NOT NULL,
    edition_date date NOT NULL,
    book_type character varying(20) NOT NULL,
    cover_type character varying(20) NOT NULL,
    edition_number character varying(13) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE public.member
(
    id integer NOT NULL GENERATED BY DEFAULT AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    full_name character varying(50) NOT NULL,
    username character varying(30) NOT NULL,
    date_of_birth date NOT NULL,
    address character varying(100) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE public.reservation
(
    id integer NOT NULL GENERATED BY DEFAULT AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    starting_date date NOT NULL,
    member_id integer NOT NULL,
    book_id integer NOT NULL,
    PRIMARY KEY (id)
);

ALTER TABLE public.reservation
    ADD FOREIGN KEY (book_id)
    REFERENCES public.book (id)
    NOT VALID;


ALTER TABLE public.reservation
    ADD FOREIGN KEY (member_id)
    REFERENCES public.member (id)
    NOT VALID;

END;