{-|
Module      : StackADT
Description : Provides the class for the Stack ADT
Copyright   : Estructuras de Datos y Alg. UNRC
License     : GPL-3
We use haddock style of comments
-}

module StackADT where

-- | A class for stacks:
-- s is a type constructor, for example: lists.
class Stack s where -- parametro es el s 
    -- | empty Stack
    empty :: s a -> s a
    -- | push an element into the Stack
    push :: s a -> a -> s a
    -- | remove the top the stack
    pop :: s a -> s a 
    -- |
    top :: s a -> a
    -- | 
    isEmpty :: (Eq a) => s a -> Bool 

-- TODO complete Stack class