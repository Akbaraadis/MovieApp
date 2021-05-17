package com.project.movie_jetpack.data.utils

import com.project.movie_jetpack.data.Movies
import com.project.movie_jetpack.data.source.local.entity.MovieEntity
import com.project.movie_jetpack.data.source.local.entity.SeriesEntity
import com.project.movie_jetpack.data.source.remote.response.MovieResponse
import com.project.movie_jetpack.data.source.remote.response.SeriesResponse

object MoviesData {

    fun generateMovies(): List<MovieEntity>{
        val movies = ArrayList<MovieEntity>()

        movies.add(MovieEntity("m1",
        "Avengers: End Game",
        "01/01/2019",
        "Setelah peristiwa yang memusnahkan setengah dari populasi Bumi di Avengers: Infinity War (2018), kisah akan berlanjut saat Avengers yang tersisa berkumpul sekali lagi untuk melawan Thanos (Josh Brolin). Namun Kesedihan, keputusasaan dan ketidakberdayaan masih tetap menyelimuti para pahlawan super. Trailer Avengers: Endgame didominasi potret \"kehancuran\" di bumi usai Thanos memusnahkan separuh populasi dunia. Warna hitm putih mendominasi cuplikan film besutan Joe dan Anthony Russo tersebut. Dalam sinopsis Avengers: Endgame, para Avengers pun berusaha untuk memulihkan tatanan alam semesta. Avengers yang tersisa seperti Steve Rogers/Captain America (Chris Evans), Natasha Romanoff/Black Widow (Scarlett Johansson) hingga Thor (Chris Hemsworth) mendapat bantuan dari Carol Danvers/Captain Marvel (Brie Larson). Hawkeye (Jeremy Renner) yang tak hadir saat Infinity War juga bakal tampil di Avengers: Endgame dengan busur dan panah andalannya. Scott Lang/Ant-Man (Paul Rudd) pun hadir membantu para Avengers yang tersisa untuk melawan Thanos.",
        "Action, Fantasy, Adventure",
        "R.drawable.avengers",
        false))

        movies.add(MovieEntity("m2",
        "Toy Story 4",
        "01/01/2019",
        "Woody selalu merasa percaya diri akan posisinya di dunia, dan prioritasnya adalah menjaga anaknya, baik itu Andy atau Bonnie. Namun ketika Bonnie menambahkan sebuah mainan baru bernama Forky dalam kamar mainannya, sebuah pengembaraan bersama teman-teman lama dan baru akan membawa Woody untuk menyaksikan betapa besarnya dunia ini bagi sebuah mainan seperti dirinya.",
        "Children, Animation, Adventure",
        "R.drawable.toy_story",
        false))

        movies.add(MovieEntity("m3",
        "Frozen II",
        "01/01/2019",
        "Anna, Elsa, Kristoff, Olaf dan Sven pergi meninggalkan Arendelle untuk melakukan perjalanan ke sebuah tempat asing dan penuh keajaiban. Mereka berangkat untuk menemukan asal usul kekuatan Elsa dan juga untuk menyelamatkan kerajaan mereka. Kali ini akan ada teks lirik lagu sehingga penonton bisa ikut bernyanyi bersama karakter Frozen II favorit mereka.",
        "Children, Animation, Adventure",
        "R.drawable.frozen",
        false))

        movies.add(MovieEntity("m4",
        "Godzilla II: King of the Monsters",
        "01/01/2019",
        "Kisah baru ini mengikuti upaya heroik agensi kripto zoologi Monarch ketika anggotanya berhadapan dengan monster seukuran dewa, termasuk Godzilla yang perkasa, yang harus berhadapan dengan Mothra, Rodan, dan musuh bebuyutannya, si kepala tiga King Ghidorah. Ketika super spesies purba iniyang sebelumnya hanya dianggap mitosbangkit kembali, mereka semua bersaing untuk supremasi, membuat keberadaan manusia tergantung dalam keseimbangan.",
        "Fiction & Action",
        "R.drawable.godzilla",
        false))

        movies.add(MovieEntity("m5",
        "Kong: Skull Island",
        "01/01/2017",
        "Sebuah tim ilmuwan menjelajahi pulau yang belum dipetakan di Pasifik, dan tak sengaja memasuki wilayah sesosok kera raksasa. Kini, mereka harus berjuang untuk melarikan diri dari kejaran para monster.",
        "Adventure & Action",
        "R.drawable.kong",
        false))

        movies.add(MovieEntity("m6",
            "Godzilla vs. Kong",
            "01/01/2021",
            "Sebuah pertarungan epic dalam sinematik Monsterverse antara Godzilla dan Kong.Pertarungan Godzilla vs. Kong membuat umat manusia harus bertahan dengan berbagai cara. Salah satunya adalah memusnahkan kedua raksasa tersebut.Siapa yang akan menang?",
            "Fiction & Action",
            "R.drawable.godzillavskong",
            false))

        movies.add(MovieEntity("m7",
            "Star Wars: The Force Awakens",
            "01/01/2015",
            "Sebuah kekuatan baru berusaha menghancurkan kekuasaan Republik. Finn, Rey, dan Poe pun bergabung dengan kelompok Resistance untuk melakukan sebuah perlawanan serta mencari Luke, Jedi yang terakhir.",
            "Fiction & Action",
            "R.drawable.star_wars",
            false))

        movies.add(MovieEntity("m8",
            "Shazam!",
            "01/01/2019",
            "Billy Batson, seorang anak yatim berusia 14 tahun yang bermasalah yang tinggal di Philadelphia, diatur untuk pindah ke rumah asuh baru - yang ketujuh berturut-turut - dengan keluarga Vazquez dan lima anak asuh lainnya. Suatu hari, Billy naik mobil subway dan menemukan dirinya diangkut ke dunia yang berbeda di mana penyihir kuno memberinya kekuatan...",
            "Action & Adventure",
            "R.drawable.shazam",
            false))

        movies.add(MovieEntity("m9",
            "My Hero Academia The Movie: Two Heroes",
            "01/01/2018",
            "All-Might dan Deku menerima undangan untuk mengunjungi sebuah kota buatan yang terapung dan disebut I Island di mana mereka bertemu seorang gadis dan bertempur melawan seorang penjahat yang menyandera para penduduk pulau itu.",
            "Action & Comedy",
            "R.drawable.bokunohero",
            false))

        movies.add(MovieEntity("m10",
            "Fate/stay night: Heaven's Feel",
            "2017",
            "Sepuluh tahun sejak Perang Holy Grail, sebuah perang yang lain terjadi di Fuyuki City. Shirou Emiya mau ikut berperang, demi memenuhi keinginan Kiritsugu sebelum meninggal. Sakura Matou adalah gadis yang jatuh cinta pada Shirou dan selalu ada di sisinya. Ketika perang dimulai, banyak pembunuhan terjadi di kota, dan suasana semaki mencekam. Shirou melindungi Sakura di rumahnya, dan bekerjasama dengan Rin Tohsaka. Tapi pertempuran semakin kacau ketika kekuatan-kekuatan tak terlihat mulai turun tangan.",
            "Action & Fantasy",
            "R.drawable.fate",
            false))

        return movies
    }

    fun generateSerries(): List<SeriesEntity>{
        val series = ArrayList<SeriesEntity>()

        series.add(SeriesEntity("t1",
                "The Falcon And The Winter Soldier: Season 1",
                "2021",
                "Setelah diserahkan mantel Captain America di akhir Avengers: Endgame (2019), Sam Wilson bergabung dengan Bucky Barnes dalam petualangan di seluruh dunia yang menguji kemampuan mereka.",
                "Action & Adventure",
                "R.drawable.falcon",
                false))

        series.add(SeriesEntity("t2",
                "Money Heist: Season 1",
                "2017",
                "Berkisah tentang sekelompok perampok bank tersebut yang dipimpin oleh seseorang yang bernama \"Profesor\". Dia merencanakan perampokan ini dengan sangat teliti dan sangat terkesan melihat semuanya tersusun rapi. Walau jenius dalam merencanakan perampokan, dia juga sangat menentang yang namanya pembunuhan dalam perampokan itu. Para perampok ini memiliki nama-nama kota sebagai panggilannya, itu semua termasuk kedalam rencana \"Profesor\" dimana tidak boleh ada data pribadi yang diketahui oleh masing-masing perampok dan tidak boleh ada hubungan lebih dari sekedar \"rekan kerja\". Namun, konflik yang selalu datang bertubi-tubi dan datang dari segala arah, konflik ini bisa datang dari perampok, profesor, polisi, dan juga para sandera.",
                "Drama",
                "R.drawable.money_heist",
                false))

        series.add(SeriesEntity("t3",
                "Into The Night: Season 1",
                "2020",
                "Secara garis besar, Into The Night menceritakan tentang perjuangan setiap karakter dalam bertahan hidup dengan cara menjauhi cahaya matahari yang dapat membunuh setiap makhluk hidup. Mereka harus bertahan di dalam sebuah pesawat yang terbang memutari bumi untuk menghindari terbitnya matahari.",
                "Drama",
                "R.drawable.into_the",
                false))

        series.add(SeriesEntity("t4",
                "The Queen's Gambit",
                "2020",
                "Berkisah tentang Beth Harmon (Anya Taylor-Joy), seorang atlet catur yang mengalami lika-liku kehidupan sejak usianya masih kecil. Ia terpaksa menyaksikan kematian ibunya saat dirinya masih sangat belia.",
                "Drama, History",
                "R.drawable.queen",
                false))

        series.add(SeriesEntity("t5",
                "The Umbrella Academy: Season 1",
                "2019",
                "Umbrella Academy Netflix menceritakan tentang kelahiran 43 bayi yang lahir dari wanita yang tidak berhubungan intim dan tidak memiliki tanda-tanda sedang hamil. Kehamilan itu terjadi secara instan dan secara tiba-tiba. Sebanyak 7 bayi dari 43 bayi yang lahir diadopsi oleh miliader yang bernama Sir Reginald Hargreeves. Tujuannya yaitu untuk mempersiapkan anak angkatnya menjadi superhero. Namun salah satu anak angkatnya tidak memiliki kekuatan super sama sekali yang bernama Vanya.\n" +
                    "\n" +
                    "Keenam anak yang lainnya yang memiliki kekuatan super antara lain Luther Hargreeves (Spaceboy), Alison Hargreeves (The Rumor), Klaus Hargreeves (The Seance), Diego Hargreeves (The Kraken), The Boy (Number Five), Ben Hargreeves (The Horror).",
                "Drama, History",
                "R.drawable.umbrella",
                false))

        series.add(SeriesEntity("t6",
                "Sherlock",
                "2009",
                "Sherlock Holmes dan rekannya Dr Watson telah berhasil memenjarakan Lord Blackwood, seorang pembunuh berantai ditakuti yang kemudian dieksekusi. Namun, Blackwood tampaknya telah kembali dari kematian.",
                "Mystery",
                "R.drawable.sherlock",
                false))

        series.add(SeriesEntity("t7",
                "Game of Thrones",
                "2011",
                "Secara garis besar, tv series ini berkisah tentang perebutan tahta kekuasaan diantara para keluarga. Bahkan mereka sampai mempertaruhkan nyawa untuk mendapatkan tahta yang mereka idam-idamkan.",
                "Drama",
                "R.drawable.game",
                false))

        series.add(SeriesEntity("t8",
                "The Walking Dead",
                "2010",
                "Tv series ini berkisah tentang dunia yang sudah hancur akibat merebaknya wabah zombie. Sehingga membuat sekelompok manusia harus bertahan hidup dengan susah payah sekaligus mempertahankan diri dari serangan zombie yang siap menerkam mereka kapan saja.",
                "Horor",
                "R.drawable.walking",
                false))

        series.add(SeriesEntity("t9",
                "Stranger Things",
                "2016",
                "Stranger Things bercerita tentang seorang anak bernama Will Byers menghilang tanpa jejak. Sehingga membuat seluruh keluarganya kebingungan. Petualangan panjang yang dilakukan keluarga dan teman-teman Will dalam mencari dirinya pun tidak semudah yang dibayangkan. Banyak hal-hal seru yang menanti mereka.",
                "Science, Fiction",
                "R.drawable.stranger",
                false))

        series.add(SeriesEntity("t10",
                "The Big Bang Theory",
                "2007",
                "Bercerita tentang kehidupan 4 orang peneliti (Sheldon, Leonard, Rajesh, dan Howard) yang bekerja di Caltech (California Institute Of Technology), karena memiliki gaya hidup Nerd maka tidak heran jika mereka sulit bersosialisasi dengan orang awam.",
                "Comedy",
                "R.drawable.bigbang",
                false))

        return series
    }

    fun generateRemoteMovie(): List<MovieResponse> {
        val movie = ArrayList<MovieResponse>()
        movie.add(MovieResponse("m460465",
                "Mortal Kombat",
                "Washed-up MMA fighter Cole Young, unaware of his heritage, and hunted by Emperor Shang Tsung's best warrior, Sub-Zero, seeks out and trains with Earth's greatest champions as he prepares to stand against the enemies of Outworld in a high stakes battle for the universe.",
                "07/04/2021",
                "Fantasi, Aksi, Petualangan, Cerita Fiksi, Cerita Seru",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/yvcNQv8fth51nWuaLwfpr50IRiO.jpg"))
        movie.add(MovieResponse("m615457",
                "Nobody",
                "Hutch Mansell, a suburban dad, overlooked husband, nothing neighbor — a \"nobody.\" When two thieves break into his home one night, Hutch's unknown long-simmering rage is ignited and propels him on a brutal path that will uncover dark secrets he fought to leave behind.",
                "26/03/2021",
                "Aksi, Cerita Seru, Kejahatan",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/oBgWY00bEFeZ9N25wWVyuQddbAo.jpg"))
        movie.add(MovieResponse("m791373",
                "Zack Snyder's Justice League",
                "Determined to ensure Superman's ultimate sacrifice was not in vain, Bruce Wayne aligns forces with Diana Prince with plans to recruit a team of metahumans to protect the world from an approaching threat of catastrophic proportions.",
                "18/03/2021",
                "Aksi, Petualangan, Fantasi, Cerita Fiksi",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/tnAuB8q5vv7Ax9UAEje5Xi4BXik.jpg"))
        movie.add(MovieResponse("m634528",
                "The Marksman",
                "Jim Hanson’s quiet life is suddenly disturbed by two people crossing the US/Mexico border – a woman and her young son – desperate to flee a Mexican cartel. After a shootout leaves the mother dead, Jim becomes the boy’s reluctant defender. He embraces his role as Miguel’s protector and will stop at nothing to get him to safety, as they go on the run from the relentless assassins.",
                "15/01/2021",
                "Aksi, Cerita Seru, Kejahatan",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/6vcDalR50RWa309vBH1NLmG2rjQ.jpg"))
        movie.add(MovieResponse("m587807",
                "Tom & Jerry",
                "Tom the cat and Jerry the mouse get kicked out of their home and relocate to a fancy New York hotel, where a scrappy employee named Kayla will lose her job if she can’t evict Jerry before a high-class wedding at the hotel. Her solution? Hiring Tom to get rid of the pesky mouse.",
                "10/03/2021",
                "Komedi, Keluarga, Animasi",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/yMoMlJo2msoVwmuf6k1C78MrB3H.jpg"))
        movie.add(MovieResponse("m458576",
                "Monster Hunter",
                "A portal transports Cpt. Artemis and an elite unit of soldiers to a strange world where powerful monsters rule with deadly ferocity. Faced with relentless danger, the team encounters a mysterious hunter who may be their only hope to find a way home.",
                "13/01/2021",
                "Fantasi, Aksi, Petualangan",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/uwjaCH7PiWrkz7oWJ4fcL3xGrb0.jpg"))
        movie.add(MovieResponse("m527774",
                "Raya and the Last Dragon",
                "Dahulu kala, di dunia fantasi Kumandra, manusia dan naga hidup bersama secara harmonis. Tetapi ketika kekuatan jahat mengancam negeri itu, para naga mengorbankan diri mereka untuk menyelamatkan umat manusia. Sekarang, 500 tahun kemudian, kejahatan yang sama telah kembali dan terserah seorang pejuang tunggal, Raya, untuk melacak naga terakhir yang legendaris untuk memulihkan tanah yang retak dan orang-orangnya yang terpecah.",
                "03/03/2021",
                "Animasi, Petualangan, Fantasi, Keluarga, Aksi",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/2AZIBU24AUn3c81WKinupffALjP.jpg"))
        movie.add(MovieResponse("m736069",
                "Justice Society: World War II",
                "While speeding off to help in an impromptu battle, The Flash blazes and rips through time, only to find himself dropped into the middle of World War II. It’s here that The Flash meets Wonder Woman and her top secret team, known as the Justice Society of America. Amidst the raging tides of war, gripping combat and the velocity of valor, The Flash must fight to return to his own timeline.",
                "27/04/2021",
                "Animasi, Kejahatan, Cerita Fiksi",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/e4REOC6CZW8J6FslA4nRvdQXFXR.jpg"))
        movie.add(MovieResponse("m664767",
                "Mortal Kombat Legends: Scorpion's Revenge",
                "After the vicious slaughter of his family by stone-cold mercenary Sub-Zero, Hanzo Hasashi is exiled to the torturous Netherrealm. There, in exchange for his servitude to the sinister Quan Chi, he’s given a chance to avenge his family – and is resurrected as Scorpion, a lost soul bent on revenge. Back on Earthrealm, Lord Raiden gathers a team of elite warriors – Shaolin monk Liu Kang, Special Forces officer Sonya Blade and action star Johnny Cage – an unlikely band of heroes with one chance to save humanity. To do this, they must defeat Shang Tsung’s horde of Outworld gladiators and reign over the Mortal Kombat tournament.",
                "12/04/2020",
                "Animasi, Aksi, Fantasi",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/4VlXER3FImHeFuUjBShFamhIp9M.jpg"))
        movie.add(MovieResponse("m299536",
                "Avengers: Infinity War",
                "Karena Avengers dan sekutunya terus melindungi dunia dari ancaman yang terlalu besar untuk ditangani oleh seorang pahlawan, bahaya baru telah muncul dari bayangan kosmik: Thanos. Seorang lalim penghujatan intergalaksi, tujuannya adalah untuk mengumpulkan semua enam Batu Infinity, artefak kekuatan yang tak terbayangkan, dan menggunakannya untuk menimbulkan kehendak memutar pada semua realitas. Segala sesuatu yang telah diperjuangkan oleh Avengers telah berkembang hingga saat ini - nasib Bumi dan keberadaannya sendiri tidak pernah lebih pasti.",
                "27/04/2018",
                "Petualangan, Aksi, Cerita Fiksi",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/7WsyChQLEftFiDOVTGkv3hFpyyt.jpg"))
        return movie
    }

    fun generateRemoteSeries(): List<SeriesResponse> {
        val series = ArrayList<SeriesResponse>()
        series.add(SeriesResponse("t100",
                "I Am Not an Animal",
                "I Am Not An Animal is an animated comedy series about the only six talking animals in the world, whose cosseted existence in a vivisection unit is turned upside down when they are liberated by animal rights activists.",
                "2004",
                "Animasi, Komedi",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/qG59J1Q7rpBc1dvku4azbzcqo8h.jpg"))
        series.add(SeriesResponse("t83097",
                "The Promised Neverland",
                "Surrounded by a forest and a gated entrance, the Grace Field House is inhabited by orphans happily living together as one big family, looked after by their \"Mama,\" Isabella. Although they are required to take tests daily, the children are free to spend their time as they see fit, usually playing outside, as long as they do not venture too far from the orphanage — a rule they are expected to follow no matter what. However, all good times must come to an end, as every few months, a child is adopted and sent to live with their new family... never to be heard from again.\n\nHowever, the three oldest siblings have their suspicions about what is actually happening at the orphanage, and they are about to discover the cruel fate that awaits the children living at Grace Field, including the twisted nature of their beloved Mama.",
                "2019",
                "Animasi, Misteri, Sci-fi & Fantasy, Aksi & Petualangan, Drama",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/8RWcKSmCbwsN8porFyTOB5e2cDG.jpg"))
        series.add(SeriesResponse("t83095",
                "盾の勇者の成り上がり",
                "Iwatani Naofumi was summoned into a parallel world along with 3 other people to become the world's Heroes. Each of the heroes respectively equipped with their own legendary equipment when summoned, Naofumi received the Legendary Shield as his weapon. Due to Naofumi's lack of charisma and experience he's labeled as the weakest, only to end up betrayed, falsely accused, and robbed by on the third day of adventure. Shunned by everyone from the king to peasants, Naofumi's thoughts were filled with nothing but vengeance and hatred. Thus, his destiny in a parallel World begins...",
                "2019",
                "Animasi, Aksi & Petualangan, Sci-fi & Fantasy, Drama",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/8yazU3CEZa97RPTMlWCc9LO4F4E.jpg"))
        series.add(SeriesResponse("t61663",
                "Your Lie in April",
                "Kousei Arima was a genius pianist until his mother's sudden death took away his ability to play. Each day was dull for Kousei. But, then he meets a violinist named Kaori Miyazono who has an eccentric playing style. Can the heartfelt sounds of the girl's violin lead the boy to play the piano again?",
                "2014",
                "Animasi, Komedi, Drama",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/rWZS22W0JgbrcQtSWDT2GvD4ilU.jpg"))
        series.add(SeriesResponse("t95557",
                "Invincible",
                "Mark Grayson is a normal teenager except for the fact that his father is the most powerful superhero on the planet. Shortly after his seventeenth birthday, Mark begins to develop powers of his own and enters into his father’s tutelage.",
                "2021",
                "Animasi, Aksi & Petualangan, Drama, Sci-fi & Fantasy",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/yDWJYRAwMNKbIYT8ZB33qy84uzO.jpg"))
        series.add(SeriesResponse("t84669",
                "The Quintessential Quintuplets",
                "Fuutarou Uesugi is a poor, antisocial ace student who one day meets the rich transfer student Itsuki Nakano. They argue but when Uesugi realizes he is to be her tutor, he tries to get on better terms. While trying to do so he meets four other girls.",
                "2019",
                "Animasi, Komedi, Drama",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/zIBfMBcV7ENjEfuFx93xJYnOtLs.jpg"))
        series.add(SeriesResponse("t60863",
                "Haikyu!!",
                "Shōyō Hinata was inspired to play volleyball after seeing Kurasuno High School's \"little giant\" competing in the national tournament on TV. He trains relentlessly to make up for his lack of height, but suffers a crushing defeat in his first and last tournament of middle school at the hands of his rival Tobio Kageyama. Vowing revenge against Kageyama and hoping to follow in the little giant's footsteps, Hinata joins Kurasuno High School's volleyball team. To his initial dismay, Kageyama is also on Kurasuno's team. The former rivals soon overcome their differences though and combine their strengths to form a legendary combo using Hinata's mobility and Kageyama's precision ball-handling. Together with their team, they compete in prefecture tournaments and promise to meet Kurasuno's fated rival school at nationals.",
                "2014",
                "Komedi, Drama, Animasi",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/qNKaeunuUdL0smnowVVgShCkWZ4.jpg"))
        series.add(SeriesResponse("t86031",
                "ドクターストーン",
                "One fateful day, all of humanity was petrified by a blinding flash of light. After several millennia, high schooler Taiju awakens and finds himself lost in a world of statues. However, he's not alone! His science-loving friend Senku's been up and running for a few months and he's got a grand plan in mind, to kickstart civilization with the power of science!",
                "2019",
                "Aksi & Petualangan, Animasi",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/jWGMYA1WzzqwrLILz5dPGiiTgZP.jpg"))
        series.add(SeriesResponse("t75006",
                "The Umbrella Academy",
                "A dysfunctional family of superheroes comes together to solve the mystery of their father's death, the threat of the apocalypse and more.",
                "2019",
                "Aksi & Petualangan, Sci-fi & Fantasy, Drama",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/uYHdIs5O8tiU5p6MvUPd2jElOH6.jpg"))
        series.add(SeriesResponse("t37854",
                "One Piece",
                "Gol D Roger dikenal sebagai Raja Bajak Laut, Orang terkuat dan paling terkenal yang pernah mengarungi Grand Line. Penangkapan dan Eksekusi Roger oleh Pemerintahan Dunia telah membawa perubahan di seluruh dunia. Kata kata terakhir sebelum kematiannya mengungkapkan lokasi dari harta karun terbesar di dunia, One Piece. Inilah awal dari era bajak laut, semua orang bermimpi menemukan One Piece (yang mana menjanjikan harta dan tahta yang tak terhingga jumlahnya), dan tentunya merebut gelar dari orang yang pertama menemukannya, gelar Raja Bajak Laut. Monkey D Luffy.",
                "1999",
                "Aksi & Petualangan, Komedi, Animasi",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/oag7edI9flSMawmNySEiSEJAbrf.jpg"))
        return series
    }

}