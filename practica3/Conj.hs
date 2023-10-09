module Conj where

class Conjuntitos s where
    vacio :: s a

    ins :: (Eq a,Ord a) => a -> s a -> s a

    union :: (Ord a,Eq a) =>s a -> s a -> s a

    pertenece :: (Eq a) => a -> s a -> Bool
