package com.project.movie_jetpack.data.utils

import com.project.movie_jetpack.R
import com.project.movie_jetpack.data.Movies

object MoviesData {

    fun generateMovies(): List<Movies>{
        val movies = ArrayList<Movies>()

        movies.add(Movies("1",
        "Avengers: End Game (2019)",
        "Action, Fantasy, Adventure",
        "Setelah peristiwa yang memusnahkan setengah dari populasi Bumi di Avengers: Infinity War (2018), kisah akan berlanjut saat Avengers yang tersisa berkumpul sekali lagi untuk melawan Thanos (Josh Brolin). Namun Kesedihan, keputusasaan dan ketidakberdayaan masih tetap menyelimuti para pahlawan super. Trailer Avengers: Endgame didominasi potret \"kehancuran\" di bumi usai Thanos memusnahkan separuh populasi dunia. Warna hitm putih mendominasi cuplikan film besutan Joe dan Anthony Russo tersebut. Dalam sinopsis Avengers: Endgame, para Avengers pun berusaha untuk memulihkan tatanan alam semesta. Avengers yang tersisa seperti Steve Rogers/Captain America (Chris Evans), Natasha Romanoff/Black Widow (Scarlett Johansson) hingga Thor (Chris Hemsworth) mendapat bantuan dari Carol Danvers/Captain Marvel (Brie Larson). Hawkeye (Jeremy Renner) yang tak hadir saat Infinity War juga bakal tampil di Avengers: Endgame dengan busur dan panah andalannya. Scott Lang/Ant-Man (Paul Rudd) pun hadir membantu para Avengers yang tersisa untuk melawan Thanos.",
        "R.drawable.avengers"))

        movies.add(Movies("2",
        "Toy Story 4 (2019)",
        "Children, Animation, Adventure",
        "Woody selalu merasa percaya diri akan posisinya di dunia, dan prioritasnya adalah menjaga anaknya, baik itu Andy atau Bonnie. Namun ketika Bonnie menambahkan sebuah mainan baru bernama Forky dalam kamar mainannya, sebuah pengembaraan bersama teman-teman lama dan baru akan membawa Woody untuk menyaksikan betapa besarnya dunia ini bagi sebuah mainan seperti dirinya.",
        "R.drawable.toy_story"))

        movies.add(Movies("3",
        "Frozen II (2019)",
        "Children, Animation, Adventure",
        "Anna, Elsa, Kristoff, Olaf dan Sven pergi meninggalkan Arendelle untuk melakukan perjalanan ke sebuah tempat asing dan penuh keajaiban. Mereka berangkat untuk menemukan asal usul kekuatan Elsa dan juga untuk menyelamatkan kerajaan mereka. Kali ini akan ada teks lirik lagu sehingga penonton bisa ikut bernyanyi bersama karakter Frozen II favorit mereka.",
        "R.drawable.frozen"))

        movies.add(Movies("4",
        "Godzilla II: King of the Monsters (2019)",
        "Fiction & Action",
        "Kisah baru ini mengikuti upaya heroik agensi kripto zoologi Monarch ketika anggotanya berhadapan dengan monster seukuran dewa, termasuk Godzilla yang perkasa, yang harus berhadapan dengan Mothra, Rodan, dan musuh bebuyutannya, si kepala tiga King Ghidorah. Ketika super spesies purba iniyang sebelumnya hanya dianggap mitosbangkit kembali, mereka semua bersaing untuk supremasi, membuat keberadaan manusia tergantung dalam keseimbangan.",
        "R.drawable.godzilla"))

        movies.add(Movies("5",
        "Kong: Skull Island (2017)",
        "Adventure & Action",
        "Sebuah tim ilmuwan menjelajahi pulau yang belum dipetakan di Pasifik, dan tak sengaja memasuki wilayah sesosok kera raksasa. Kini, mereka harus berjuang untuk melarikan diri dari kejaran para monster.",
        "R.drawable.kong"))

        movies.add(Movies("6",
            "Godzilla vs. Kong (2021)",
            "Fiction & Action",
            "Sebuah pertarungan epic dalam sinematik Monsterverse antara Godzilla dan Kong.Pertarungan Godzilla vs. Kong membuat umat manusia harus bertahan dengan berbagai cara. Salah satunya adalah memusnahkan kedua raksasa tersebut.Siapa yang akan menang?",
            "R.drawable.godzillavskong"))

        movies.add(Movies("7",
            "Star Wars: The Force Awakens (2015)",
            "Fiction & Action",
            "Sebuah kekuatan baru berusaha menghancurkan kekuasaan Republik. Finn, Rey, dan Poe pun bergabung dengan kelompok Resistance untuk melakukan sebuah perlawanan serta mencari Luke, Jedi yang terakhir.",
            "R.drawable.star_wars"))

        movies.add(Movies("8",
            "Shazam! (2019)",
            "Action & Adventure",
            "Billy Batson, seorang anak yatim berusia 14 tahun yang bermasalah yang tinggal di Philadelphia, diatur untuk pindah ke rumah asuh baru - yang ketujuh berturut-turut - dengan keluarga Vazquez dan lima anak asuh lainnya. Suatu hari, Billy naik mobil subway dan menemukan dirinya diangkut ke dunia yang berbeda di mana penyihir kuno memberinya kekuatan...",
            "R.drawable.shazam"))

        movies.add(Movies("9",
            "My Hero Academia The Movie: Two Heroes (2018)",
            "Action & Comedy",
            "All-Might dan Deku menerima undangan untuk mengunjungi sebuah kota buatan yang terapung dan disebut I Island di mana mereka bertemu seorang gadis dan bertempur melawan seorang penjahat yang menyandera para penduduk pulau itu.",
            "R.drawable.bokunohero"))

        movies.add(Movies("10",
            "Fate/stay night: Heaven's Feel  (2017)",
            "Action & Fantasy",
            "Sepuluh tahun sejak Perang Holy Grail, sebuah perang yang lain terjadi di Fuyuki City. Shirou Emiya mau ikut berperang, demi memenuhi keinginan Kiritsugu sebelum meninggal. Sakura Matou adalah gadis yang jatuh cinta pada Shirou dan selalu ada di sisinya. Ketika perang dimulai, banyak pembunuhan terjadi di kota, dan suasana semaki mencekam. Shirou melindungi Sakura di rumahnya, dan bekerjasama dengan Rin Tohsaka. Tapi pertempuran semakin kacau ketika kekuatan-kekuatan tak terlihat mulai turun tangan.",
            "R.drawable.fate"))

        return movies
    }

    fun generateSerries(): List<Movies>{
        val series = ArrayList<Movies>()

        series.add(Movies("1",
        "The Falcon And The Winter Soldier: Season 1 (2021)",
        "Action & Adventure",
        "Setelah diserahkan mantel Captain America di akhir Avengers: Endgame (2019), Sam Wilson bergabung dengan Bucky Barnes dalam petualangan di seluruh dunia yang menguji kemampuan mereka.",
        "R.drawable.falcon"))

        series.add(Movies("2",
                "Money Heist: Season 1 (2017)",
                "Drama",
                "Berkisah tentang sekelompok perampok bank tersebut yang dipimpin oleh seseorang yang bernama \"Profesor\". Dia merencanakan perampokan ini dengan sangat teliti dan sangat terkesan melihat semuanya tersusun rapi. Walau jenius dalam merencanakan perampokan, dia juga sangat menentang yang namanya pembunuhan dalam perampokan itu. Para perampok ini memiliki nama-nama kota sebagai panggilannya, itu semua termasuk kedalam rencana \"Profesor\" dimana tidak boleh ada data pribadi yang diketahui oleh masing-masing perampok dan tidak boleh ada hubungan lebih dari sekedar \"rekan kerja\". Namun, konflik yang selalu datang bertubi-tubi dan datang dari segala arah, konflik ini bisa datang dari perampok, profesor, polisi, dan juga para sandera.",
                "R.drawable.money_heist"))

        series.add(Movies("3",
            "Into The Night: Season 1 (2020)",
            "Drama",
            "Secara garis besar, Into The Night menceritakan tentang perjuangan setiap karakter dalam bertahan hidup dengan cara menjauhi cahaya matahari yang dapat membunuh setiap makhluk hidup. Mereka harus bertahan di dalam sebuah pesawat yang terbang memutari bumi untuk menghindari terbitnya matahari.",
            "R.drawable.into_the"))

        series.add(Movies("4",
            "The Queen's Gambit (2020)",
            "Drama, History",
            "Berkisah tentang Beth Harmon (Anya Taylor-Joy), seorang atlet catur yang mengalami lika-liku kehidupan sejak usianya masih kecil. Ia terpaksa menyaksikan kematian ibunya saat dirinya masih sangat belia.",
            "R.drawable.queen"))

        series.add(Movies("5",
            "The Umbrella Academy: Season 1 (2019)",
            "Drama",
            "Umbrella Academy Netflix menceritakan tentang kelahiran 43 bayi yang lahir dari wanita yang tidak berhubungan intim dan tidak memiliki tanda-tanda sedang hamil. Kehamilan itu terjadi secara instan dan secara tiba-tiba. Sebanyak 7 bayi dari 43 bayi yang lahir diadopsi oleh miliader yang bernama Sir Reginald Hargreeves. Tujuannya yaitu untuk mempersiapkan anak angkatnya menjadi superhero. Namun salah satu anak angkatnya tidak memiliki kekuatan super sama sekali yang bernama Vanya.\n" +
                    "\n" +
                    "Keenam anak yang lainnya yang memiliki kekuatan super antara lain Luther Hargreeves (Spaceboy), Alison Hargreeves (The Rumor), Klaus Hargreeves (The Seance), Diego Hargreeves (The Kraken), The Boy (Number Five), Ben Hargreeves (The Horror).",
            "R.drawable.umbrella"))

        series.add(Movies("6",
            "Sherlock (2009)",
            "Mystery",
            "Sherlock Holmes dan rekannya Dr Watson telah berhasil memenjarakan Lord Blackwood, seorang pembunuh berantai ditakuti yang kemudian dieksekusi. Namun, Blackwood tampaknya telah kembali dari kematian.",
            "R.drawable.sherlock"))

        series.add(Movies("7",
            "Game of Thrones (2011)",
            "Drama",
            "Secara garis besar, tv series ini berkisah tentang perebutan tahta kekuasaan diantara para keluarga. Bahkan mereka sampai mempertaruhkan nyawa untuk mendapatkan tahta yang mereka idam-idamkan.",
            "R.drawable.game"))

        series.add(Movies("8",
            "The Walking Dead (2010)",
            "Horor",
            "Tv series ini berkisah tentang dunia yang sudah hancur akibat merebaknya wabah zombie. Sehingga membuat sekelompok manusia harus bertahan hidup dengan susah payah sekaligus mempertahankan diri dari serangan zombie yang siap menerkam mereka kapan saja.",
            "R.drawable.walking"))

        series.add(Movies("9",
            "Stranger Things (2016)",
            "Science, Fiction",
            "Stranger Things bercerita tentang seorang anak bernama Will Byers menghilang tanpa jejak. Sehingga membuat seluruh keluarganya kebingungan. Petualangan panjang yang dilakukan keluarga dan teman-teman Will dalam mencari dirinya pun tidak semudah yang dibayangkan. Banyak hal-hal seru yang menanti mereka.",
            "R.drawable.stranger"))

        series.add(Movies("10",
            "The Big Bang Theory (2007)",
            "Comedy",
            "Bercerita tentang kehidupan 4 orang peneliti (Sheldon, Leonard, Rajesh, dan Howard) yang bekerja di Caltech (California Institute Of Technology), karena memiliki gaya hidup Nerd maka tidak heran jika mereka sulit bersosialisasi dengan orang awam.",
            "R.drawable.bigbang"))

        return series
    }
}