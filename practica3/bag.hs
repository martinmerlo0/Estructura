f :: (Int,Int) -> Int
f (a,b) = a

s :: (Int,Int) -> Int
s (a,b) = b


ins :: (Int,Int) -> [(Int,Int)] -> [(Int,Int)]
ins a [] = [a]
ins a (x:xs) | (f a == f x) = (f a, s a + s x) : xs -- en caso de ser iguales se suman las segundas componentes y se concatenan
             | otherwise = x:ins a xs -- caso que las primeras componentes son distintas


pertenece :: Int -> [(Int,Int)] -> Bool
pertenece e [] = False 
pertenece e (x:xs) | (e == f x ) = True
                   | otherwise = pertenece e xs 

union :: [(Int,Int)] -> [(Int,Int)] -> [(Int,Int)]
union [] ys = ys
union xs [] = xs
union (x:xs) (y:ys) | pertenece (f x) (y:ys) = (f x, s x + buscar (f x) (y:ys)): union xs (eliminar (f x) (y:ys))
                    | otherwise = x : union xs (y:ys)


buscar :: Int -> [(Int,Int)] -> Int
buscar e [] = 0
buscar e (x:xs) = if e == f x then s x else buscar e xs

eliminar :: Int -> [(Int,Int)] -> [(Int,Int)]
eliminar e [] = []
eliminar e (x:xs) = if e == f x then xs else x : eliminar e xs 

interseccion :: [Int] -> [Int] -> [Int]
interseccion xs [] = []
interseccion [] xs = []
interseccion (x:xs) (y:ys) | pertenece2 x (y:ys) = x : interseccion xs (eliminar2 x (y:ys))
                           | otherwise = interseccion xs (y:ys)


pertenece2 :: Int -> [Int] -> Bool
pertenece2 e [] = False
pertenece2 e (x:xs) = if e == x then  True else pertenece2 e xs 


eliminar2 :: Int -> [Int] -> [Int]
eliminar2 e [] = []
eliminar2 e (x:xs) = if e == x then xs else eliminar2 e xs



resta :: [Int] -> [Int] -> [Int]
resta [] [] = []
resta xs [] = xs
resta [] ys = []
resta (x:xs) ys | pertenece2 x ys = resta xs ys 
                | otherwise = x : resta xs ys 


resta2 :: [Int] -> [Int] -> [Int]
resta2 [] [] = []
resta2 xs [] = xs
resta2 [] ys = []
resta2 (x:xs) (y:ys) | (x == y) = resta2 xs ys
                     | otherwise = x : resta2 xs (y:ys)




rm :: Int -> [Int] -> [Int]
rm e [] = []
rm e (x:xs) | (e == x) = xs
            | otherwise = x : rm e xs



sort [] = []
sort (x:xs) = insert x (sort xs)
insert x [] = [x]
insert x (y:ys) = if x <= y then x : (y:ys) else y:(insert x ys)