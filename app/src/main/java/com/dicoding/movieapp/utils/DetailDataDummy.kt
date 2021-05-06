package com.dicoding.movieapp.utils

import com.dicoding.movieapp.data.source.local.ActorEntity
import com.dicoding.movieapp.data.source.local.MovieDetailEntity
import com.dicoding.movieapp.data.source.local.TVShowDetailEntity

object DetailDataDummy {
    fun getMovieDetail():ArrayList<MovieDetailEntity>{
        val movieDetailList = ArrayList<MovieDetailEntity>()
        movieDetailList.add(
            MovieDetailEntity("m1",
            "Miguel Arteta",
            "Always feeling like they have to say \"no\" to their kids, Allison and Carlos decide to give their three kids a \"Yes Day,\" during which the kids have 24 hours to make the rules.",
            "https://www.youtube.com/watch?v=Y-3Vr8Ut8d0",
            "https://i.ytimg.com/vi/Y-3Vr8Ut8d0/maxresdefault.jpg",
                    createArray(
                            ActorEntity("Jenna Ortega","https://upload.wikimedia.org/wikipedia/commons/d/d0/Jenna_Ortega_2020.jpg"),
                            ActorEntity("Jennifer Garner","https://www.minews.id/wp-content/uploads/2021/03/garner.jpg"),
                            ActorEntity("Edgar Ramirez","https://upload.wikimedia.org/wikipedia/commons/a/a5/Edgar_Ramirez_by_Gage_Skidmore.jpg"),
                            ActorEntity("Julian Lerner","https://m.media-amazon.com/images/M/MV5BNWU2NmIyNDQtODdjYS00MzJhLTgwYzItNTRkODQzMzVhOTYxXkEyXkFqcGdeQXVyNjk2ODg3MDk@._V1_.jpg"),
                            ActorEntity("Everly Carganilla","https://1.bp.blogspot.com/-qPVIq9YTRYI/YFn_xYEG9gI/AAAAAAAACm0/U2_GSg20ydgzxKpDQlI_XXTTSa5U2dhAwCLcBGAsYHQ/s534/everly_carganilla.jpg"),
                            ActorEntity("Nat Faxon","https://static.wikia.nocookie.net/disney/images/a/a0/Nat_Faxon.jpg/revision/latest?cb=20181011144345")
                    )
            )
        )
        movieDetailList.add(
            MovieDetailEntity("m2",
            "M. Irfan Ramli",
            "This film tells the story of the life of Abby (Ari Irham) who was hit by sadness and guilt after the death of her sister, Indah (Aghniny Haque) who died in a plane crash. This sadness makes Abby live her life full of despair.",
            "https://www.youtube.com/watch?v=mi0WCydHnbY",
            "https://i.ytimg.com/vi/mi0WCydHnbY/maxresdefault.jpg",
                    createArray(
                            ActorEntity("Ari Irham","https://cdn.idntimes.com/content-images/post/20170905/19933231-151830225384706-2687549225394241536-n-b14f5bddbf44840b662c16bc241040c3_600x400.jpg"),
                            ActorEntity("Aghniny Haque","https://asset-a.grid.id/crop/0x0:0x0/700x0/photo/2019/08/16/198711639.jpg"),
                            ActorEntity("Jennifer Coppen","https://cdn.idntimes.com/content-images/post/20200809/jennifercoppenreal20-1594976675-739f7a3e6d66aab30fe0fe9f34ad9575_600x400.jpg"),
                            ActorEntity("Taskya Namya","https://3.bp.blogspot.com/-3EgVdk9JK7s/W03D42_y8ZI/AAAAAAAAFSc/tMR7pJzv4PQeIDuKzEe-Aa3vi1XKOFDtQCLcBGAs/s1600/taskya%2Bnamya.jpg"),
                            ActorEntity("Wafda Saifan","https://upload.wikimedia.org/wikipedia/commons/d/db/Wafda-Saifan.jpg"),
                            ActorEntity("Marcella Zalianty","https://blue.kumparan.com/image/upload/fl_progressive,fl_lossy,c_fill,q_auto:best,w_640/v1576760858/knp0ji0ujppgkfycevgx.jpg")
                    )
            )
        )
        movieDetailList.add(
            MovieDetailEntity("m3",
            "Thor Freudenthal",
            "Diagnosed with a mental illness during his senior year of high school, a witty, introspective teen struggles to keep it a secret while falling in love with a brilliant classmate who inspires him to open his heart and not be defined by his condition.",
            "https://www.youtube.com/watch?v=4E1-RnpOe8Q",
            "https://i.ytimg.com/vi/HAaTSdSKbH4/maxresdefault.jpg",
                    createArray(
                            ActorEntity("Charlie Plummer","https://resizing.flixster.com/cKCXmqgi-UiqTOq7hpkHCpXuyKE=/506x652/v2/https://flxt.tmsimg.com/v9/AllPhotos/663324/663324_v9_bb.jpg"),
                            ActorEntity("Taylor Russell","https://i.pinimg.com/originals/0a/3a/c5/0a3ac545faa0f823f0c55068387464d5.jpg"),
                            ActorEntity("AnnaSophia Robb","https://media.gettyimages.com/photos/annasophia-robb-arrives-at-the-walt-disney-television-emmy-party-on-picture-id1170378069?s=612x612"),
                            ActorEntity("Andy Garcia","https://i.pinimg.com/originals/5f/1e/33/5f1e33007a553de4773c95ecb3d1880b.jpg"),
                            ActorEntity("Walton Goggins","https://resizing.flixster.com/-YEzs1SdSFZyDY2VokkAfW4-BTI=/506x652/v2/https://flxt.tmsimg.com/v9/AllPhotos/168000/168000_v9_bb.jpg"),
                            ActorEntity("Molly Parker","https://resizing.flixster.com/zlzIULwNhMc8nZXo2COyNPNfnKM=/506x652/v2/https://flxt.tmsimg.com/v9/AllPhotos/72685/72685_v9_bc.jpg")
                    )
            )
        )
        movieDetailList.add(
            MovieDetailEntity("m4",
            "Tim Hill",
            "When SpongeBob SquarePants' beloved pet snail Gary goes missing, a path of clues leads SpongeBob and his best friend Patrick to the powerful King Poseidon, who has Gary held captive in the Lost City of Atlantic City. On their mission to save Gary, SpongeBob and the Bikini Bottom gang team up for a heroic and hilarious journey, where they discover nothing is stronger than the power of friendship.",
            "https://www.youtube.com/watch?v=HfiH_526qhY",
            "https://i.ytimg.com/vi/HfiH_526qhY/maxresdefault.jpg",
                    createArray(
                            ActorEntity("Keanu Reeves","https://cdn.popbela.com/content-images/post/20191226/keanu-036c463ea1f3c42605f00bbf3bb432e5-600x400-f6e818c0f30f3727dded88e555785751_750x500.jpg"),
                            ActorEntity("Snoop Dogg","https://upload.wikimedia.org/wikipedia/commons/6/61/Snoop_crop.jpg"),
                            ActorEntity("Stephen Hillenburg","https://photo.jpnn.com/arsip/normal/2018/11/28/pencipta-tokoh-animasi-spongebob-squarepants-stephen-hillenburg-meninggal-dunia-foto-dimitrios-kambourisgetty-images-for-paramount-international.jpg"),
                            ActorEntity("Danny Trejo","https://pbs.twimg.com/profile_images/742397576704450560/gEkBVdZ-_400x400.jpg"),
                            ActorEntity("Awkwafina","https://m.media-amazon.com/images/M/MV5BMTU0NTUwNjkyN15BMl5BanBnXkFtZTgwMjM0NzEzMTI@._V1_UY317_CR7,0,214,317_AL_.jpg"),
                            ActorEntity("Tom Kenny","https://static.wikia.nocookie.net/spongebob/images/6/6c/Tom_Image.jpg/revision/latest/top-crop/width/360/height/360?cb=20201127042010")
                    )
            )
        )
        movieDetailList.add(
            MovieDetailEntity("m5",
            "Lee Chung-Hyeon",
            "Connected by phone in the same home but 20 years apart, a serial killer puts another woman's past -- and life -- on the line to change her own fate.",
            "https://www.youtube.com/watch?v=hxkKeniT-0Q",
            "https://i.ytimg.com/vi/_17gbzv8eIA/maxresdefault.jpg",
                    createArray(
                            ActorEntity("Park Shin-Hye","https://asianwiki.com/images/8/8e/Park_Shin-Hye-11-27-2016.jpg"),
                            ActorEntity("Jeon Jong-Seo","https://vcdn-giaitri.vnecdn.net/2020/12/03/JeonJongSeotop-1607002647-5553-1607002688.jpg?w=0&h=0&q=100&dpr=1&fit=crop&s=PiVXyltbXgq_xdIoFyQzzQ"),
                            ActorEntity("Lee El","https://6.vikiplatform.com/image/646a5347c5f74f3b978e17468ca2edc8.jpeg?x=b&a=0x0&s=460x268&e=t&f=t&cb=1"),
                            ActorEntity("Kim Sung-Ryung","https://vfan-phinf.pstatic.net/20190830_210/1567095655746MMJxg_JPEG/1E971942-32D7-4F8E-BF4E-9BFCDCD20686-533x800.jpeg?type=e1920"),
                            ActorEntity("Oh Jung-Se","https://cdn.idntimes.com/content-images/community/2020/07/how-the-judges-selected-these-5-winners-on-the-56th-baeksang-arts-awards-57d0eb93dcdf6d787bce441489741fe6.jpeg"),
                            ActorEntity("Park Ho-San","https://i.mydramalist.com/1L5gyf.jpg")
                    )
            )
        )
        movieDetailList.add(
            MovieDetailEntity("m6",
            "Mikael Håfström",
            "In the near future, a drone pilot sent into a war zone finds himself paired up with a top-secret android officer on a mission to stop a nuclear attack.",
            "https://www.youtube.com/watch?v=u8ZsUivELbs",
            "https://i.ytimg.com/vi/u8ZsUivELbs/hq720.jpg?sqp=-oaymwEhCK4FEIIDSFryq4qpAxMIARUAAAAAGAElAADIQj0AgKJD&rs=AOn4CLDsBlPM_0_gCpM4FZpaj6SCjLSc4g",
                    createArray(
                            ActorEntity("Anthony Mackie","https://m.media-amazon.com/images/M/MV5BMTk3NTM1MjE2M15BMl5BanBnXkFtZTcwNzc5OTI2Mg@@._V1_UY317_CR17,0,214,317_AL_.jpg"),
                            ActorEntity("Damson Idris","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTOvDoxBlN_VaD6aCgXbqltSvC8rOXyXjbCUA&usqp=CAU"),
                            ActorEntity("Kristina Tonteri-Young","https://pbs.twimg.com/profile_images/1091313769656053760/TWivSc1Y_400x400.jpg"),
                            ActorEntity("Emily Beecham","https://pbs.twimg.com/profile_images/1371836951179968521/UNT5pg6M_400x400.jpg"),
                            ActorEntity("Pilou Asbaek","https://m.media-amazon.com/images/M/MV5BNTEzMjUxODc5M15BMl5BanBnXkFtZTcwMjkwMjgxNA@@._V1_UY1200_CR209,0,630,1200_AL_.jpg"),
                            ActorEntity("Michael Kelly","https://m.media-amazon.com/images/M/MV5BMTkyOTMwNTM1MV5BMl5BanBnXkFtZTgwNzUxODA1NjE@._V1_UY1200_CR120,0,630,1200_AL_.jpg")
                    )
            )
        )
        movieDetailList.add(
            MovieDetailEntity("m7",
            "Ludovico Di Martino",
            "Leonida Riva is a solitary war veteran who has spent years away from his family. When his daughter,Teresa, is kidnapped, he rediscovers the anger and ferocity he thought he had buried in the past.",
            "https://www.youtube.com/watch?v=beiUGVgMIgw",
            "https://i.ytimg.com/vi/beiUGVgMIgw/maxresdefault.jpg",
                    createArray(
                            ActorEntity("Fabrizio Gifuni","https://pad.mymovies.it/filmclub/attori/7519.jpg"),
                            ActorEntity("Lino Musella","https://www.themoviedb.org/t/p/w235_and_h235_face/xZuVRh6zyh4fo5QsxERHu25l3P4.jpg"),
                            ActorEntity("Andrea Pennacchi","http://www.torinoggi.it/typo3temp/pics/A_f8358b2673.jpg"),
                            ActorEntity("Giada Gagliardi","https://artworks.thetvdb.com/banners/person/8009011/62079816.jpg"),
                            ActorEntity("Monica Piseddu","https://m.media-amazon.com/images/M/MV5BMGRlOTk2MGMtYzg2Yi00NGQ0LTg0ZGYtNTEyMTdlNTk1ZDU2XkEyXkFqcGdeQXVyNDE5MTU2MDE@._V1_.jpg"),
                            ActorEntity("Andrei Nova","https://snusercontent.global.ssl.fastly.net/member-headshot-square-large/07/3502007_8892464.jpg")
                    )
            )
        )
        movieDetailList.add(
            MovieDetailEntity("m8",
            "Lasja Fauzia",
            "Fearing rejection, a young man struggles to declare his feelings for his best friend, who soon falls for another man -- until a fateful incident.",
            "https://www.youtube.com/watch?v=I2RPo_szXDs",
            "https://i.ytimg.com/vi/5sia4S6E_YY/hqdefault.jpg",
                    createArray(
                            ActorEntity("Jefri Nichol","https://cdns.klimg.com/merdeka.com/i/w/news/2020/02/28/1151407/540x270/tidak-hanya-digugat-rp-42-miliar-ini-deretan-kasus-yang-disebabkan-jefri-nichol.jpg"),
                            ActorEntity("Aurora Ribero","https://asset.kompas.com/crops/MaagyS54xiuBg5rLj4HsR2qaF7Y=/0x0:1000x667/750x500/data/photo/2017/12/14/1649047565.jpg"),
                            ActorEntity("Nadya Arina","https://media.suara.com/pictures/970x544/2019/04/12/10353-nadya-arina.jpg"),
                            ActorEntity("Rebecca Klopper","https://1.bp.blogspot.com/-VAeMXI_vfzc/XYjpZ6y5zlI/AAAAAAAALb8/LJQrJeUHBPYKHF5bwANdXySMygxtn1HOgCLcBGAsYHQ/s1600/_aaaaaaaarev.jpg"),
                            ActorEntity("Axel Matthew Thomas","https://media.matamata.com/thumbs/2021/03/18/87255-axel-matthew-instagramataxelmatthewthomas/745x489-img-87255-axel-matthew-instagramataxelmatthewthomas.jpg"),
                            ActorEntity("Karina Suwandi","https://cdn-2.tstatic.net/makassar/foto/bank/images/10-tahun-vakum-di-industri-hiburan-kabar-terbaru-karina-suwandi-sempat-eksis-di-warkop-milenium.jpg")
                    )
            )
        )
        movieDetailList.add(
            MovieDetailEntity("m9",
            "Sam Hargrave",
            "A black-market mercenary who has nothing to lose is hired to rescue the kidnapped son of an imprisoned international crime lord. But in the murky underworld of weapons dealers and drug traffickers, an already deadly mission approaches the impossible.",
            "https://www.youtube.com/watch?v=L6P3nI6VnlY",
            "https://i.ytimg.com/vi/L6P3nI6VnlY/maxresdefault.jpg",
                    createArray(
                            ActorEntity("Chris Hemsworth","https://static.republika.co.id/uploads/images/inpicture_slide/chris-hemsworth-_181006125016-887.jpg"),
                            ActorEntity("Golshifteh Farahani","https://i.pinimg.com/originals/5e/10/f8/5e10f8ff957d4307ea4025e4367eddda.jpg"),
                            ActorEntity("Randeep Hooda","https://static.toiimg.com/thumb/msid-77780172,width-800,height-600,resizemode-75,imgsize-32278,pt-32,y_pad-40/77780172.jpg"),
                            ActorEntity("Sam Hargrave","https://i.pinimg.com/originals/5a/b3/d6/5ab3d618c6c4504ff045834b7a8c27db.jpg"),
                            ActorEntity("Rudhraksh Jaiswal","https://data1.ibtimes.co.in/en/full/718393/rudraksh-jaiswal.jpg"),
                            ActorEntity("David Harbour","https://resizing.flixster.com/1AVQLNDvVs969RHVs_wX4dyOOFU=/506x652/v2/https://flxt.tmsimg.com/v9/AllPhotos/277640/277640_v9_ba.jpg")
                    )
            )
        )
        movieDetailList.add(
            MovieDetailEntity("m10",
            "Kornél Mundruczó",
            "A heartbreaking home birth leaves a woman grappling with the profound emotional fallout, isolated from her partner and family by a chasm of grief.",
            "https://www.youtube.com/watch?v=1zLKbMAZNGI",
            "https://i.ytimg.com/vi/1zLKbMAZNGI/maxresdefault.jpg",
                    createArray(
                            ActorEntity("Vanessa Kirby","https://upload.wikimedia.org/wikipedia/commons/thumb/7/77/Vanessa_Kirby_MTV.jpg/220px-Vanessa_Kirby_MTV.jpg"),
                            ActorEntity("Shia LaBeouf","https://cdn1-production-images-kly.akamaized.net/YGorV2MEPNfcCw736y2JKBp5vMk=/640x360/smart/filters:quality(75):strip_icc():format(jpeg)/kly-media-production/medias/530615/original/shia-labeouf-131218c.jpg"),
                            ActorEntity("Ellen Burstyn","https://resizing.flixster.com/uhiCogitdYRQdS0oS-ZipL1lQHo=/506x652/v2/https://flxt.tmsimg.com/v9/AllPhotos/248/248_v9_bb.jpg"),
                            ActorEntity("Molly Parker","https://resizing.flixster.com/zlzIULwNhMc8nZXo2COyNPNfnKM=/506x652/v2/https://flxt.tmsimg.com/v9/AllPhotos/72685/72685_v9_bc.jpg"),
                            ActorEntity("Sarah Snook","https://upload.wikimedia.org/wikipedia/commons/3/3e/Sarah_Snook_2012.jpg"),
                            ActorEntity("Iliza Shlesinger","https://bucket.mn2s.com/wp-content/uploads/2019/11/20180630/Iliza-Shlesinger-mn2s.png")
                    )
            )
        )

        return movieDetailList
    }

    fun getShowDetail():ArrayList<TVShowDetailEntity>{
        val showDetailList = ArrayList<TVShowDetailEntity>()
        showDetailList.add(
                TVShowDetailEntity("s1",
                "Kim Min-Kyeong",
                "A pianist hits rock bottom and finds herself at a piano academy in a small village where she falls in love with a mystery man.",
                "https://www.youtube.com/watch?v=QJVJsXpdxEQ",
                "https://i.ytimg.com/vi/QJVJsXpdxEQ/maxresdefault.jpg",
                        createArray(
                                ActorEntity("Lee Jae-Wook","https://asset.kompas.com/crops/8HfPJ_hcJekjNV1MGK3BGVq8DnY=/0x0:0x0/750x500/data/photo/2020/08/03/5f27f6a5abf1a.png"),
                                ActorEntity("Go Ara","https://upload.wikimedia.org/wikipedia/commons/thumb/a/a5/190211_%EA%B3%A0%EC%95%84%EB%9D%BC.jpg/220px-190211_%EA%B3%A0%EC%95%84%EB%9D%BC.jpg"),
                                ActorEntity("Kim Joo-Hun","https://i.mydramalist.com/RRd2V_5f.jpg"),
                                ActorEntity("Lee Si-Woo","https://i.mydramalist.com/kPD4d_5c.jpg"),
                                ActorEntity("Shin Eun-Soo","https://asianwiki.com/images/8/81/Shin_Eun-Soo-P2.jpg"),
                                ActorEntity("Ye Ji-Won","https://cdn.idntimes.com/content-images/community/2019/07/clhqcwxusaae-bt-picsay-416863e41d662e2db55d48bf5ba2f3aa_600x400.jpg")
                        )
                )
        )
        showDetailList.add(
                TVShowDetailEntity("s2",
                "Kim Hee-Won",
                "During a visit to his motherland, a Korean-Italian mafia lawyer gives a conglomerate a taste of its own medicine with a side of justice.",
                "https://www.youtube.com/watch?v=S12-4mXCNj4&vl=en",
                "https://i.ytimg.com/vi/S12-4mXCNj4/maxresdefault.jpg",
                        createArray(
                                ActorEntity("Song Joong-Ki","https://asianwiki.com/images/e/e8/Song_Joong-Ki-p002.jpeg"),
                                ActorEntity("Jeon Yeo-Been","https://i.mydramalist.com/W3BXOf.jpg"),
                                ActorEntity("Ok Taecyeon","https://asset.kompas.com/crops/NE-VvoAtjdyz7jxa0jqZKzkbvgI=/1x0:1000x666/750x500/data/photo/2018/07/25/3835559199.png"),
                                ActorEntity("Kwak Dong-Yeon","https://upload.wikimedia.org/wikipedia/commons/2/2b/Kwak_Dong-yeon_at_Nov_2018.png"),
                                ActorEntity("Kim Yeo-Jin","https://asianwiki.com/images/e/ee/Kim_Yeo-Jin-1974-p1.jpg"),
                                ActorEntity("Kim Yoon-Hye","https://i.mydramalist.com/R4zjz_5c.jpg")
                        )
                )
        )
        showDetailList.add(
                TVShowDetailEntity("s3",
                "Peter Hoar",
                "On one day in 1989, 43 infants are inexplicably born to random, unconnected women who showed no signs of pregnancy the day before. Seven are adopted by billionaire industrialist Sir Reginald Hargreeves, who creates the Umbrella Academy and prepares his \"children\" to save the world.",
                "https://www.youtube.com/watch?v=0DAmWHxeoKw",
                "https://i.ytimg.com/vi/0DAmWHxeoKw/maxresdefault.jpg",
                        createArray(
                                ActorEntity("Aidan Gallagher","https://cdn.idntimes.com/content-images/community/2020/06/inshot-20200608-183717830-compress59-4eccdb341cf5f79641d9c9191aecdbe1_600x400.jpg"),
                                ActorEntity("Elliot Page","https://cdn1-production-images-kly.akamaized.net/mui3B_KOAzBePU4q5QaBGpFMTuU=/0x92:3374x1993/640x360/filters:quality(75):strip_icc():format(jpeg)/kly-media-production/medias/3312653/original/027499700_1606868758-AP20336683005033.jpg"),
                                ActorEntity("Robert Sheehan","https://www.irishtimes.com/polopoly_fs/1.2133678.1426166292!/image/image.jpg_gen/derivatives/ratio_4x3_w1200/image.jpg"),
                                ActorEntity("Emmy Raver-Lampman","https://upload.wikimedia.org/wikipedia/commons/b/bd/Emmy_raver_lampman_2019_mtv.png"),
                                ActorEntity("Tom Hopper","https://m.media-amazon.com/images/M/MV5BN2Y1OGZjNWUtYTdmMy00OGQxLTg5MmYtOTRjMjMxZWI1NTJhXkEyXkFqcGdeQXVyMjQwMDg0Ng@@._V1_UY1200_CR585,0,630,1200_AL_.jpg"),
                                ActorEntity("David Castaneda","https://image.tmdb.org/t/p/w500//5ClaQPDoFKBRmQrjuiomq01uSgC.jpg")
                        )
                )
        )
        showDetailList.add(
                TVShowDetailEntity("s4",
                "Mika Ninagawa",
                "In every corner of the world robotic people join social networks and give their time and privacy away in the name of connectedness. These people are social voyeurs, narcissists and attention addicts. Japan is not any different. A woman is a photographer. Another arrives in the country's capital city looking for her fame. People are inspired by a social network star.",
                "https://www.youtube.com/watch?v=otf-9H4sOsc",
                "https://i.ytimg.com/vi/otf-9H4sOsc/maxresdefault.jpg",
                        createArray(
                                ActorEntity("Elaiza Ikeda","https://i.mydramalist.com/kxvvb_5c.jpg"),
                                ActorEntity("Shuhei Uesugi","https://asianwiki.com/images/8/82/Shuhei_Uesugi-p1.jpg"),
                                ActorEntity("KOM_I","https://i.mydramalist.com/koZ6gc.jpg"),
                                ActorEntity("Miki Nakatani","http://2.bp.blogspot.com/-gvTjxLXBnVg/Unsw3bh7UFI/AAAAAAAAJM8/GSlCNiRl2Es/s1600/aeeea6d63091ea5ed6182a1f772a304c.jpg"),
                                ActorEntity("Goto Yutaro","https://i.mydramalist.com/2XQdk_5c.jpg"),
                                ActorEntity("Mari Natsuki","https://cdn-japantimes.com/wp-content/uploads/2018/02/p10-ito-mari-natsuki-a-20180225-e1519459588144.jpg")
                        )
                )
        )
        showDetailList.add(
                TVShowDetailEntity("s5",
                "Jin Hyuk",
                "Sisyphus: The Myth tells the story of a genius engineer named Han Tae-sul (Cho Seung-woo), who tries to uncover the truth behind his older brother's death, and a mysterious woman called Gang Seo-hae (Park Shin-hye), who travels back in time to help him save the world from imminent danger.",
                "https://www.youtube.com/watch?v=THaIZihZoMg",
                "https://i.ytimg.com/vi/THaIZihZoMg/maxresdefault.jpg",
                        createArray(
                                ActorEntity("Park Shin-Hye","https://0.soompi.io/wp-content/uploads/2020/11/24183711/Park-Shin-Hye-6.jpg"),
                                ActorEntity("Cho Seung-Woo","https://i.mydramalist.com/QmdJ7c.jpg"),
                                ActorEntity("Chae Jong-Hyeop","https://i.mydramalist.com/rlYKy_5f.jpg"),
                                ActorEntity("Hye-In Jeong","https://asianwiki.com/images/6/6a/Jung_Hye-In-p1.jpg"),
                                ActorEntity("Lee Si-Woo","https://i.mydramalist.com/kPD4d_5c.jpg"),
                                ActorEntity("Kim Byung-Chul","https://asianwiki.com/images/f/f5/Kim_Byung-Chul-p1.jpg")
                        )
                )
        )
        showDetailList.add(
                TVShowDetailEntity("s6",
                "Shin-Woo Park",
                "Ko Moon-young got obsessed with Moon Gang-tae. You will notice that it is an obsession and not love because she likes to manipulate people. She can't do that with Gang-tae which makes her more interested in him. Along the way, they met the people of OK Psychiatric Hospital.",
                "https://www.youtube.com/watch?v=50ek4HQo0Bc",
                "https://i.ytimg.com/vi/50ek4HQo0Bc/maxresdefault.jpg",
                        createArray(
                                ActorEntity("Seo Yea-Ji","https://assets.pikiran-rakyat.com/crop/0x0:0x0/x/photo/2021/04/15/1188729312.png"),
                                ActorEntity("Kim Soo-Hyun","https://upload.wikimedia.org/wikipedia/commons/a/a3/Kim_Soo-hyun_2014_PaekSang_Arts_Awards06b.jpg"),
                                ActorEntity("Park Gyu-Young","https://asianwiki.com/images/1/1b/Park_Gyu-Young-1993-p1.jpg"),
                                ActorEntity("Kwak Dong-Yeon","https://upload.wikimedia.org/wikipedia/commons/2/2b/Kwak_Dong-yeon_at_Nov_2018.png"),
                                ActorEntity("Oh Jung-Se","https://upload.wikimedia.org/wikipedia/commons/b/bc/Oh_Jeong-se_2020.jpg"),
                                ActorEntity("Kim Joo-Hun","https://i.mydramalist.com/RRd2V_5f.jpg")
                        )
                )
        )
        //createArray("Bianca Comparato","Rodolfo Valente","Cynthia Senek","Vaneza Oliveira","Michel Gomez","Rafael Lozano")
        showDetailList.add(
                TVShowDetailEntity("s7",
                "César Charlone",
                "A post-apocalyptic thriller set in near-future Brazil, where a select few are allowed to join a privileged society after undergoing an intense and competitive process. A world divided into progress and devastation.",
                "https://www.youtube.com/watch?v=8yyzNQfaQR8",
                "https://i.ytimg.com/vi/8yyzNQfaQR8/maxresdefault.jpg",
                        createArray(
                                ActorEntity("Bianca Comparato","https://i.pinimg.com/originals/a9/b0/3a/a9b03aea40b818541cb5a71653dc7c31.jpg"),
                                ActorEntity("Rodolfo Valente","https://m.media-amazon.com/images/M/MV5BNGQ3MDhhNzctOGVhNS00NTBhLWE1ZjYtYmQwOWVmZmJmZGUyXkEyXkFqcGdeQXVyNDg4MjkzNDk@._V1_.jpg"),
                                ActorEntity("Cynthia Senek","https://ans-wer.com/wp-content/uploads/2019/08/cynthia-senek.jpg"),
                                ActorEntity("Vaneza Oliveira","https://articlebio.com/uploads/biography/2018/04/20/vaneza-oliveira.jpg"),
                                ActorEntity("Michel Gomes","https://www.themoviedb.org/t/p/original/qdDeRIRL5MBn6BXMEpKE913VJIL.jpg"),
                                ActorEntity("Rafael Lozano","https://www.pacegallery.com/media/images/rlh_portrait.original.jpg")
                        )
                )
        )
        showDetailList.add(
                TVShowDetailEntity("s8",
                "Oh Choong Hwan",
                "Set in South Korea's fictional Silicon Valley called Sandbox, Start-Up tells the story of people in the world of startup companies. Seo Dal-mi (Bae Suzy) is a bright and ambitious young woman who dreams of becoming Korea's Steve Jobs.",
                "https://www.youtube.com/watch?v=BemKyzbLDDc",
                "https://i.ytimg.com/vi/BemKyzbLDDc/maxresdefault.jpg",
                        createArray(
                                ActorEntity("Kim Seon-Ho","https://upload.wikimedia.org/wikipedia/commons/4/40/Kim-Seon-Ho_%28cropped%29.jpg"),
                                ActorEntity("Nam Joo-Hyuk","https://i.mydramalist.com/250rk_5f.jpg"),
                                ActorEntity("Bae Suzy","https://i.mydramalist.com/pOqyQc.jpg"),
                                ActorEntity("Kang Han Na","https://i.mydramalist.com/68Jrdc.jpg"),
                                ActorEntity("Stephanie Lee","https://i.mydramalist.com/xyyjN_5f.jpg"),
                                ActorEntity("Yeo Jin-Goo","https://asianwiki.com/images/d/da/Yeo_Jin-Goo-The_Long_Way_Home-GV.jpg")
                        )
                )
        )
        showDetailList.add(
                TVShowDetailEntity("s9",
                "Kim Seong-Yoon",
                "On the first day of attending his new high school, Park Sae-Ro-Yi (Park Seo-Joon) punches his classmate Jang Geun-Won, who was bullying another classmate. The bully is the son of CEO Jang Dae-Hee (Yoo Jae-Myung). The bully's father runs restaurant business Jagga where Park Sae-Ro-Yi’s own father works.",
                "https://www.youtube.com/watch?v=NeaHNQJ1kCo",
                "https://i.ytimg.com/vi/NeaHNQJ1kCo/maxresdefault.jpg",
                        createArray(
                                ActorEntity("Park Seo-Joon","https://i.mydramalist.com/j8meyf.jpg"),
                                ActorEntity("Kim Da-Mi","https://cdn.idntimes.com/content-images/community/2020/02/20200211-164255-3308-efeb008f2766fe23f4e5f89fd52d0a9a.jpg"),
                                ActorEntity("Kwon Nara","https://i.mydramalist.com/r7OD7_5f.jpg"),
                                ActorEntity("Park Bo-Gum","https://i.mydramalist.com/p3Qx8_5c.jpg"),
                                ActorEntity("Lee Joo-Young","https://asianwiki.com/images/1/11/Lee_Joo-Young-p1.jpg"),
                                ActorEntity("Dong-Hee","https://asianwiki.com/images/d/de/Kim_Dong-Hee_%281999%29-P1.jpg")
                        )
                )
        )
        //createArray("Álvaro Morte","Úrsula Corberó","Itziar Ituño","Miguel Herrán","Alba Flores","Jaime Lorente")
        showDetailList.add(
                TVShowDetailEntity("s10",
                "Jesus Colmenar",
                "A criminal mastermind who goes by \"The Professor\" has a plan to pull off the biggest heist in recorded history -- to print billions of euros in the Royal Mint of Spain.",
                "https://www.youtube.com/watch?v=GuIvzozPVak",
                "https://i.ytimg.com/vi/GuIvzozPVak/maxresdefault.jpg",
                        createArray(
                                ActorEntity("Álvaro Morte","https://m.media-amazon.com/images/M/MV5BZGVlMTQyODEtNTlmZS00MTg1LWEwNmYtZmRlNjFmNzg0MDNhXkEyXkFqcGdeQXVyMTA0MjU0Ng@@._V1_UY1200_CR86,0,630,1200_AL_.jpg"),
                                ActorEntity("Úrsula Corberó","https://pbs.twimg.com/profile_images/1055549103013289986/M5iid-z5_400x400.jpg"),
                                ActorEntity("Itziar Ituño","https://upload.wikimedia.org/wikipedia/commons/8/87/Itziar_Itu%C3%B1o_2017.jpg"),
                                ActorEntity("Miguel Herrán","https://i.pinimg.com/originals/2b/99/aa/2b99aa9966bd759375f9dd8ccc02c2c7.jpg"),
                                ActorEntity("Alba Flores","https://superstarsbio.com/wp-content/uploads/2019/10/Alba-Flores-Dress.jpg"),
                                ActorEntity("Jaime Lorente","https://static.wikia.nocookie.net/elite-netflix/images/0/05/Jaime_Lorente.jpg/revision/latest?cb=20190820080506")
                        )
                )
        )
        return showDetailList
    }

    private fun createArray(vararg actorEntity: ActorEntity): ArrayList<ActorEntity> {
        val array = ArrayList<ActorEntity>()
        for (item in actorEntity){
            array.add(item)
        }
        return array
    }
}