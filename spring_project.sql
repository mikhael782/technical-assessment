PGDMP      9                }            spring_project    17.3    17.3     1           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                           false            2           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                           false            3           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                           false            4           1262    16388    spring_project    DATABASE     t   CREATE DATABASE spring_project WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'en-US';
    DROP DATABASE spring_project;
                     postgres    false            �            1259    16432    karyawan    TABLE     �   CREATE TABLE public.karyawan (
    id integer NOT NULL,
    nama_karyawan character varying(100) NOT NULL,
    jabatan character varying(50) NOT NULL,
    user_id integer,
    created_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP
);
    DROP TABLE public.karyawan;
       public         heap r       postgres    false            �            1259    16431    karyawan_id_seq    SEQUENCE     �   CREATE SEQUENCE public.karyawan_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public.karyawan_id_seq;
       public               postgres    false    220            5           0    0    karyawan_id_seq    SEQUENCE OWNED BY     C   ALTER SEQUENCE public.karyawan_id_seq OWNED BY public.karyawan.id;
          public               postgres    false    219            �            1259    16420    users    TABLE       CREATE TABLE public.users (
    id bigint NOT NULL,
    username character varying(50) NOT NULL,
    email character varying(100) NOT NULL,
    password character varying(255) NOT NULL,
    created_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP
);
    DROP TABLE public.users;
       public         heap r       postgres    false            �            1259    16419    users_id_seq    SEQUENCE     �   CREATE SEQUENCE public.users_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 #   DROP SEQUENCE public.users_id_seq;
       public               postgres    false    218            6           0    0    users_id_seq    SEQUENCE OWNED BY     =   ALTER SEQUENCE public.users_id_seq OWNED BY public.users.id;
          public               postgres    false    217            �           2604    16435    karyawan id    DEFAULT     j   ALTER TABLE ONLY public.karyawan ALTER COLUMN id SET DEFAULT nextval('public.karyawan_id_seq'::regclass);
 :   ALTER TABLE public.karyawan ALTER COLUMN id DROP DEFAULT;
       public               postgres    false    219    220    220            �           2604    16446    users id    DEFAULT     d   ALTER TABLE ONLY public.users ALTER COLUMN id SET DEFAULT nextval('public.users_id_seq'::regclass);
 7   ALTER TABLE public.users ALTER COLUMN id DROP DEFAULT;
       public               postgres    false    217    218    218            .          0    16432    karyawan 
   TABLE DATA           S   COPY public.karyawan (id, nama_karyawan, jabatan, user_id, created_at) FROM stdin;
    public               postgres    false    220   W       ,          0    16420    users 
   TABLE DATA           J   COPY public.users (id, username, email, password, created_at) FROM stdin;
    public               postgres    false    218   T       7           0    0    karyawan_id_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.karyawan_id_seq', 7, true);
          public               postgres    false    219            8           0    0    users_id_seq    SEQUENCE SET     :   SELECT pg_catalog.setval('public.users_id_seq', 5, true);
          public               postgres    false    217            �           2606    16438    karyawan karyawan_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.karyawan
    ADD CONSTRAINT karyawan_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.karyawan DROP CONSTRAINT karyawan_pkey;
       public                 postgres    false    220            �           2606    16440    karyawan karyawan_user_id_key 
   CONSTRAINT     [   ALTER TABLE ONLY public.karyawan
    ADD CONSTRAINT karyawan_user_id_key UNIQUE (user_id);
 G   ALTER TABLE ONLY public.karyawan DROP CONSTRAINT karyawan_user_id_key;
       public                 postgres    false    220            �           2606    16430    users users_email_key 
   CONSTRAINT     Q   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_email_key UNIQUE (email);
 ?   ALTER TABLE ONLY public.users DROP CONSTRAINT users_email_key;
       public                 postgres    false    218            �           2606    16448    users users_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.users DROP CONSTRAINT users_pkey;
       public                 postgres    false    218            �           2606    16428    users users_username_key 
   CONSTRAINT     W   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_username_key UNIQUE (username);
 B   ALTER TABLE ONLY public.users DROP CONSTRAINT users_username_key;
       public                 postgres    false    218            �           2606    16449    karyawan karyawan_user_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.karyawan
    ADD CONSTRAINT karyawan_user_id_fkey FOREIGN KEY (user_id) REFERENCES public.users(id) ON DELETE SET NULL;
 H   ALTER TABLE ONLY public.karyawan DROP CONSTRAINT karyawan_user_id_fkey;
       public               postgres    false    4754    218    220            .   �   x�}��N�0E���4��8٥�!T!�
݌��M�;���V*�v�{ν�������K�}�����=�=������Q-r\����VX�Uv]*�����|eh�<��A������#/a
Xrv�#��<j���R��g���d�W�Wصǈ�B�(k�g��Q ���嫿��8Ş`��&�ѳv�gҞA�W�L(T�`6voH;�$�������d������1�jm_      ,   �   x����
�@F�ק�P�q�h�ϢEѢ6m>R�)G骁o�?��\8�Õt�/�,�"��8�6(:Cn\V�����T��I�*�C�K-d��r)A�t�cOѡ1p.���5�-�g��q6њ?��!����^NZ��4�r���855�^?��:���tΆovq�8�(��x&�Q�&o��y_x(p�     