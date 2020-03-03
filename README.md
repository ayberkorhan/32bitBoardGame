# BoardGame
Java dilinde yazdığım satranç tahtası üzerinde yol bulmaya yönelik basit bir oyun

## Kurallar
- Oyun beyaz bir pulun oyun tahtası üzerinde bir uçtan ( A1 ) diğer uça ( H8 ) gitmesini amaçlamaktadır. 

- Oyun başlangıcında oyun tahtası üzerine; 

	- A1 konumuna beyaz pul yerleştirilmelidir. 
	- Oyunun kurallarını bozmayacak şekilde random olarak 0 ile 9 adet arasında siyah pullar yerleştirilmelidir. 
	- Oyun her zaman bitebilmelidir. 

- Pullar birbirlerini yiyemez yada üzerinden atlayarak geçemezler. 
- A1 noktasından harekete başlayacak olan beyaz pul H8 konumuna geldiğinde oyun bitmiştir. 
- Beyaz pul H8 konumuna ulaşırken; 
	- En az bir siyah pul ile karşılaşmalıdır. 
	- H8 konumuna gidilirken karşılaşılan siyah pulların konumları oyun sonunda belirtilmelidir. 

	- Beyaz pul H8 konumuna mümkün olduğunca en kısa yoldan ulaşmalıdır.  
-  Beyaz pulun takip ettiği adımlar oyun sonunda belirtilmelidir. 