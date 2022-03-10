from pytube import YouTube

link = input("Introdueix un link de un video: ")

yt = YouTube(link)

#Detalls del video
print("Titol del Video: ", yt.title)
print("Numero de visites: ", yt.views)
print("Duracio del video: ", yt.length)
#Conseguir la major resolucio posible
ys = yt.streams.get_highest_resolution()
#Descarga del video
print("Descarregant video...")
ys.download()
print("Descarga completada")



