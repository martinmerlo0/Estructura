{-|
Module      : StackList
Description : Provides an implementation using lists for the Stack ADT
Copyright   : Estructuras de Datos y Alg. UNRC
License     : GPL-3
We use haddock style of comments
-}

module StackList  where
import StackADT

instance Stack [] where -- instancia la clase que defino usando Listas 
    empty xs = []
    push xs x = (x:xs)
    pop (x:xs) = xs
    top xs = head xs
    isEmpty xs = if xs == [] then True else False
-- TODO complete Stack instance