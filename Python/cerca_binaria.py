#Cerca nativa: Escaneja tota la llista i pregunta si es igual al target
#Si es igual, retorna el index
#Si no es igual, llavors retorna -1
import string


def cerca_nativa(l,target):
    for i in range(len(l)):
        if l[i]==target:
            return i
    return -1


def cerca_binaria(l, target,inferior=None,superior=None):
    
    if inferior is None:
        inferior=0
    if superior is None:
        superior = len(l)-1
    
    if superior <inferior:
        return -1

    intermig = (superior+inferior)//2

    if(l[intermig]==target):
        return intermig
    elif target <l[intermig]:
        return cerca_binaria(l,target,inferior,intermig-1)
    else:
        return cerca_binaria(l,target,intermig+1,superior)


array = [4,9,1,0,5,6]
x=5

resultat = cerca_binaria(array,x,0, len(array)-1)

if resultat !=-1:
    print("L'element es present al index "+ str(resultat))
else:
    print("No trobat")