package com.project.movie_jetpack.data.utils

import com.project.movie_jetpack.R
import com.project.movie_jetpack.data.Movies

object MoviesData {

    fun generateMovies(): List<Movies>{
        val movies = ArrayList<Movies>()

        movies.add(Movies("m1",
        "Avengers: End Game",
        "01/01/2019",
        "Setelah peristiwa yang memusnahkan setengah dari populasi Bumi di Avengers: Infinity War (2018), kisah akan berlanjut saat Avengers yang tersisa berkumpul sekali lagi untuk melawan Thanos (Josh Brolin). Namun Kesedihan, keputusasaan dan ketidakberdayaan masih tetap menyelimuti para pahlawan super. Trailer Avengers: Endgame didominasi potret \"kehancuran\" di bumi usai Thanos memusnahkan separuh populasi dunia. Warna hitm putih mendominasi cuplikan film besutan Joe dan Anthony Russo tersebut. Dalam sinopsis Avengers: Endgame, para Avengers pun berusaha untuk memulihkan tatanan alam semesta. Avengers yang tersisa seperti Steve Rogers/Captain America (Chris Evans), Natasha Romanoff/Black Widow (Scarlett Johansson) hingga Thor (Chris Hemsworth) mendapat bantuan dari Carol Danvers/Captain Marvel (Brie Larson). Hawkeye (Jeremy Renner) yang tak hadir saat Infinity War juga bakal tampil di Avengers: Endgame dengan busur dan panah andalannya. Scott Lang/Ant-Man (Paul Rudd) pun hadir membantu para Avengers yang tersisa untuk melawan Thanos.",
        "Action, Fantasy, Adventure",
        "R.drawable.avengers"))

        movies.add(Movies("m2",
        "Toy Story 4",
        "01/01/2019",
        "Woody selalu merasa percaya diri akan posisinya di dunia, dan prioritasnya adalah menjaga anaknya, baik itu Andy atau Bonnie. Namun ketika Bonnie menambahkan sebuah mainan baru bernama Forky dalam kamar mainannya, sebuah pengembaraan bersama teman-teman lama dan baru akan membawa Woody untuk menyaksikan betapa besarnya dunia ini bagi sebuah mainan seperti dirinya.",
        "Children, Animation, Adventure",
        "R.drawable.toy_story"))

        movies.add(Movies("m3",
        "Frozen II",
        "01/01/2019",
        "Anna, Elsa, Kristoff, Olaf dan Sven pergi meninggalkan Arendelle untuk melakukan perjalanan ke sebuah tempat asing dan penuh keajaiban. Mereka berangkat untuk menemukan asal usul kekuatan Elsa dan juga untuk menyelamatkan kerajaan mereka. Kali ini akan ada teks lirik lagu sehingga penonton bisa ikut bernyanyi bersama karakter Frozen II favorit mereka.",
        "Children, Animation, Adventure",
        "R.drawable.frozen"))

        movies.add(Movies("m4",
        "Godzilla II: King of the Monsters",
        "01/01/2019",
        "Kisah baru ini mengikuti upaya heroik agensi kripto zoologi Monarch ketika anggotanya berhadapan dengan monster seukuran dewa, termasuk Godzilla yang perkasa, yang harus berhadapan dengan Mothra, Rodan, dan musuh bebuyutannya, si kepala tiga King Ghidorah. Ketika super spesies purba iniyang sebelumnya hanya dianggap mitosbangkit kembali, mereka semua bersaing untuk supremasi, membuat keberadaan manusia tergantung dalam keseimbangan.",
        "Fiction & Action",
        "R.drawable.godzilla"))

        movies.add(Movies("m5",
        "Kong: Skull Island",
        "01/01/2017",
        "Sebuah tim ilmuwan menjelajahi pulau yang belum dipetakan di Pasifik, dan tak sengaja memasuki wilayah sesosok kera raksasa. Kini, mereka harus berjuang untuk melarikan diri dari kejaran para monster.",
        "Adventure & Action",
        "R.drawable.kong"))

        movies.add(Movies("m6",
            "Godzilla vs. Kong",
            "01/01/2021",
            "Sebuah pertarungan epic dalam sinematik Monsterverse antara Godzilla dan Kong.Pertarungan Godzilla vs. Kong membuat umat manusia harus bertahan dengan berbagai cara. Salah satunya adalah memusnahkan kedua raksasa tersebut.Siapa yang akan menang?",
            "Fiction & Action",
            "R.drawable.godzillavskong"))

        movies.add(Movies("m7",
            "Star Wars: The Force Awakens",
            "01/01/2015",
            "Sebuah kekuatan baru berusaha menghancurkan kekuasaan Republik. Finn, Rey, dan Poe pun bergabung dengan kelompok Resistance untuk melakukan sebuah perlawanan serta mencari Luke, Jedi yang terakhir.",
            "Fiction & Action",
            "R.drawable.star_wars"))

        movies.add(Movies("m8",
            "Shazam!",
            "01/01/2019",
            "Billy Batson, seorang anak yatim berusia 14 tahun yang bermasalah yang tinggal di Philadelphia, diatur untuk pindah ke rumah asuh baru - yang ketujuh berturut-turut - dengan keluarga Vazquez dan lima anak asuh lainnya. Suatu hari, Billy naik mobil subway dan menemukan dirinya diangkut ke dunia yang berbeda di mana penyihir kuno memberinya kekuatan...",
            "Action & Adventure",
            "R.drawable.shazam"))

        movies.add(Movies("m9",
            "My Hero Academia The Movie: Two Heroes",
            "01/01/2018",
            "All-Might dan Deku menerima undangan untuk mengunjungi sebuah kota buatan yang terapung dan disebut I Island di mana mereka bertemu seorang gadis dan bertempur melawan seorang penjahat yang menyandera para penduduk pulau itu.",
            "Action & Comedy",
            "R.drawable.bokunohero"))

        movies.add(Movies("m10",
            "Fate/stay night: Heaven's Feel",
            "2017",
            "Sepuluh tahun sejak Perang Holy Grail, sebuah perang yang lain terjadi di Fuyuki City. Shirou Emiya mau ikut berperang, demi memenuhi keinginan Kiritsugu sebelum meninggal. Sakura Matou adalah gadis yang jatuh cinta pada Shirou dan selalu ada di sisinya. Ketika perang dimulai, banyak pembunuhan terjadi di kota, dan suasana semaki mencekam. Shirou melindungi Sakura di rumahnya, dan bekerjasama dengan Rin Tohsaka. Tapi pertempuran semakin kacau ketika kekuatan-kekuatan tak terlihat mulai turun tangan.",
            "Action & Fantasy",
            "R.drawable.fate"))

        return movies
    }

    fun generateSerries(): List<Movies>{
        val series = ArrayList<Movies>()

        series.add(Movies("t1",
        "The Falcon And The Winter Soldier: Season 1",
        "2021",
        "Setelah diserahkan mantel Captain America di akhir Avengers: Endgame (2019), Sam Wilson bergabung dengan Bucky Barnes dalam petualangan di seluruh dunia yang menguji kemampuan mereka.",
        "Action & Adventure",
                "R.drawable.falcon"))

        series.add(Movies("t2",
                "Money Heist: Season 1",
                "2017",
                "Berkisah tentang sekelompok perampok bank tersebut yang dipimpin oleh seseorang yang bernama \"Profesor\". Dia merencanakan perampokan ini dengan sangat teliti dan sangat terkesan melihat semuanya tersusun rapi. Walau jenius dalam merencanakan perampokan, dia juga sangat menentang yang namanya pembunuhan dalam perampokan itu. Para perampok ini memiliki nama-nama kota sebagai panggilannya, itu semua termasuk kedalam rencana \"Profesor\" dimana tidak boleh ada data pribadi yang diketahui oleh masing-masing perampok dan tidak boleh ada hubungan lebih dari sekedar \"rekan kerja\". Namun, konflik yang selalu datang bertubi-tubi dan datang dari segala arah, konflik ini bisa datang dari perampok, profesor, polisi, dan juga para sandera.",
                "Drama",
                "R.drawable.money_heist"))

        series.add(Movies("t3",
            "Into The Night: Season 1",
            "2020",
            "Secara garis besar, Into The Night menceritakan tentang perjuangan setiap karakter dalam bertahan hidup dengan cara menjauhi cahaya matahari yang dapat membunuh setiap makhluk hidup. Mereka harus bertahan di dalam sebuah pesawat yang terbang memutari bumi untuk menghindari terbitnya matahari.",
            "Drama",
                "R.drawable.into_the"))

        series.add(Movies("t4",
            "The Queen's Gambit",
            "2020",
            "Berkisah tentang Beth Harmon (Anya Taylor-Joy), seorang atlet catur yang mengalami lika-liku kehidupan sejak usianya masih kecil. Ia terpaksa menyaksikan kematian ibunya saat dirinya masih sangat belia.",
            "Drama, History",
                "R.drawable.queen"))

        series.add(Movies("t5",
            "The Umbrella Academy: Season 1",
            "2019",
            "Umbrella Academy Netflix menceritakan tentang kelahiran 43 bayi yang lahir dari wanita yang tidak berhubungan intim dan tidak memiliki tanda-tanda sedang hamil. Kehamilan itu terjadi secara instan dan secara tiba-tiba. Sebanyak 7 bayi dari 43 bayi yang lahir diadopsi oleh miliader yang bernama Sir Reginald Hargreeves. Tujuannya yaitu untuk mempersiapkan anak angkatnya menjadi superhero. Namun salah satu anak angkatnya tidak memiliki kekuatan super sama sekali yang bernama Vanya.\n" +
                    "\n" +
                    "Keenam anak yang lainnya yang memiliki kekuatan super antara lain Luther Hargreeves (Spaceboy), Alison Hargreeves (The Rumor), Klaus Hargreeves (The Seance), Diego Hargreeves (The Kraken), The Boy (Number Five), Ben Hargreeves (The Horror).",
            "Drama, History",
                "R.drawable.umbrella"))

        series.add(Movies("t6",
            "Sherlock",
            "2009",
            "Sherlock Holmes dan rekannya Dr Watson telah berhasil memenjarakan Lord Blackwood, seorang pembunuh berantai ditakuti yang kemudian dieksekusi. Namun, Blackwood tampaknya telah kembali dari kematian.",
            "Mystery",
                "R.drawable.sherlock"))

        series.add(Movies("t7",
            "Game of Thrones",
            "2011",
            "Secara garis besar, tv series ini berkisah tentang perebutan tahta kekuasaan diantara para keluarga. Bahkan mereka sampai mempertaruhkan nyawa untuk mendapatkan tahta yang mereka idam-idamkan.",
            "Drama",
                "R.drawable.game"))

        series.add(Movies("t8",
            "The Walking Dead",
            "2010",
            "Tv series ini berkisah tentang dunia yang sudah hancur akibat merebaknya wabah zombie. Sehingga membuat sekelompok manusia harus bertahan hidup dengan susah payah sekaligus mempertahankan diri dari serangan zombie yang siap menerkam mereka kapan saja.",
            "Horor",
                "R.drawable.walking"))

        series.add(Movies("t9",
            "Stranger Things",
            "2016",
            "Stranger Things bercerita tentang seorang anak bernama Will Byers menghilang tanpa jejak. Sehingga membuat seluruh keluarganya kebingungan. Petualangan panjang yang dilakukan keluarga dan teman-teman Will dalam mencari dirinya pun tidak semudah yang dibayangkan. Banyak hal-hal seru yang menanti mereka.",
            "Science, Fiction",
                "R.drawable.stranger"))

        series.add(Movies("t10",
            "The Big Bang Theory",
            "2007",
            "Bercerita tentang kehidupan 4 orang peneliti (Sheldon, Leonard, Rajesh, dan Howard) yang bekerja di Caltech (California Institute Of Technology), karena memiliki gaya hidup Nerd maka tidak heran jika mereka sulit bersosialisasi dengan orang awam.",
            "Comedy",
                "R.drawable.bigbang"))

        return series
    }
}