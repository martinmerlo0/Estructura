module ConjuntosListas where
import Conj 

instance Conjuntitos [] where 
    vacio = []

    ins e [] = [e]
    ins e (x:xs) | e < x = e:x:xs
                 | e > x = x:ins e xs
                 | otherwise =  x:xs
            

    union [] xs = xs
    union xs [] = xs
    union (x:xs) (y:ys) | x < y = x:union xs (y:ys)
                        | x > y = y:union (x:xs) ys
                        | otherwise = x:union xs ys

    
    pertenece e [] = False
    pertenece e (x:xs) | (e == x) = True
                       | otherwise = pertenece e xs 