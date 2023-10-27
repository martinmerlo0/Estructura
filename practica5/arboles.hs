data Arbol a = Nil | Nodo a (Arbol a) (Arbol a)

mapTree :: (a -> b) -> Arbol a -> Arbol b
mapTree f Nil = Nil
mapTree f (Nodo x hi hd) = Nodo (f x) (mapTree f hi) (mapTree f hd)