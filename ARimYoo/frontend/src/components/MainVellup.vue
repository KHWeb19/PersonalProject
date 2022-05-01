<template>
    <v-container >
        <v-row class="imgGallery fill-height" align="center" justify="center" >
            <template  v-for="(item, i) in items">
                <v-col :key="i"  class="container">
                    <div class="hoverImg">
                        <img  class="img" :src="item.img" style="width:260px"/>
                        <div class="hoverContent">
                            <v-icon x-small color="white">mdi-circle</v-icon>
                         {{item.content}} 
                         <p class="hoverEx">
                         {{item.explain}}
                         </p>
                        </div>
                    </div>
                </v-col>
            </template>
        </v-row>
        <v-row justify="center" class="bestBoard" >
            <v-col cols="5">
                <v-list>
                    <v-list-item-title class="listTitle pt-2 pb-2">
                        <v-icon small dark>mdi-circle</v-icon>&nbsp;
                        <strong>Best community post</strong>
                    </v-list-item-title>
                    <div v-for ="(item, index) in communityBest" :key="index">
                        <v-list-item class="mt-3" style="font-size:11pt">
                            <v-icon x-small class="ml-5 mr-4 " color="black">
                                mdi-circle
                            </v-icon>
                            {{item.brackets}} &nbsp;
                            <router-link :to="`/community/${item.boardNo}`"
                            class="bestTitle">{{item.title}}
                            </router-link>
                            <v-spacer />
                            💛
                            {{item.likeCnt}}
                        </v-list-item>
                    <v-divider class="ml-5"/>
                    </div>
                </v-list>
            </v-col>
            <v-divider vertical class="mr-10 ml-10"/>
            <v-col cols="5">
                 <v-list>
                    <v-list-item-title class="listTitle pt-2 pb-2">
                        <v-icon small dark>mdi-circle</v-icon>&nbsp;
                        <strong>Best Review post</strong>
                    </v-list-item-title>
                    <div v-for ="(item, index) in reviewBest" :key="index">
                        <v-list-item class="mt-3" style="font-size:11pt">
                            <v-icon x-small class="ml-5 mr-4 " color="black">
                                mdi-circle
                            </v-icon>
                            {{item.brackets}} &nbsp;
                            <router-link :to="`/review/${item.reviewNo}`"
                            class="bestTitle">{{item.title}}
                            </router-link>
                            <v-spacer />
                            💛
                            {{item.likeCnt}}
                        </v-list-item>
                    <v-divider class="ml-5"/>
                    </div>
                </v-list>
            </v-col>
        </v-row>
        <div class="halfMain">
                <v-row justify="start">
                    <div class="content1 mt-15">
                        <img src="@/assets/Levelup.png" id="Phrases1">
                        <p/>
                        <img src="@/assets/your.png" id="Phrases2">
                        <p/>
                        <img src="@/assets/ds.png" id="Phrases3">
                    </div>
                </v-row>
                <v-row>
                    <div class="content3">
                        <img src="@/assets/arrow.png" style="width:550px; height:200px;">
                    </div>
                    <div class="content2">
                        <img src="@/assets/main/homebanner_ghost.png" class="ghost1" style="width:100px">
                        <img src="@/assets/main/homebanner_ghost.png" class="ghost2" style="width:200px">
                        <img src="@/assets/main/homebanner_ghost.png" class="ghost3" style="width:300px">
                    </div>
                </v-row>
        </div>
    </v-container>
</template>

<script>
import animater from '@/assets/animater.js';

export default {
    name:'MainVellup',
    data () {
        return {
            items: [
                {explain: 'a strong feeling of enthusiasm or excitement for something or about doing develop' ,content:'Passion', img: require('@/assets/main/main4.jpg') },
                {explain:'Our ideas about develop are always smart and interesting', content:'smart', img: require('@/assets/main/main3.png')},
                {explain:'We are the people who lead the future', content:'future', img: require('@/assets/main/main2.png')},
                {explain:'Do action of working with someone to produce or create idea', content:'collaboration', img: require('@/assets/main/main1.png')}
            ],
        }
    },
    props: {
        communityBest: {
            type:Array
        },
        reviewBest: {
            type:Array
        }
    },
    mounted() {
       animater.animater1()
       animater.animater2()
    }
}
   
</script>

<style scoped>
.mainSearch{
    border-radius:5px;
    position: relative;
    width:400px;
    height:38px;
    background-color: rgb(240, 238, 238);
    outline-color: rgb(204, 32, 32);
    padding-left:10px;
    font-family: 'Noto Sans KR', sans-serif;
    float:left;
}
.imgGallery{
    margin-top:3%;
    margin-left:auto;
    margin-right:auto;
}
.bestBoard{
    font-family: 'Noto Sans KR', sans-serif;
    margin-top:5%;
    height: 380px;
}
.listTitle {
    background-color:rgb(206, 24, 24);
    border-radius: 20px;
    box-shadow: 7px 7px 5px rgb(206, 205, 205);
    color:white;
    padding-left:3%;
    width:70%;
}
.bestTitle {
    color:black;
}
.bestTitle:hover{
    color:rgb(206, 24, 24);
}
.container{
    position: relative;
    overflow: hidden;
}
.hoverContent {
    position: absolute;
    top: 150%;
    transform: translate( -50%, -50% );
    left:50%;
    z-index:2;
    color:white;
    transition: all .35s ;
    font-family: 'Noto Sans KR', sans-serif;
}
.hoverEx{
    font-size:1pt;
    color:rgb(202, 202, 202);
    margin-top:5px;
}
.hoverImg:hover .hoverContent{
    top: 50%;
    color:white;
}
.hoverImg:hover .img{
     filter: brightness(50%); 
}

/* -------------- logo ----------------*/

.halfMain {
    margin-top:3%;
    background: linear-gradient(0deg, rgb(214, 214, 214), white);
    background-color: rgb(226, 222, 222);
    padding: 10% 10% 0 10%
}
.halfMain img {
    opacity: 0;
}
#Phrases1 {
    position: relative;
    zoom:0.45;
    left: 250px;
    transform:rotate(-20deg);
}
#Phrases2 {
    position: relative;
    zoom:0.45;
    transform:rotate(-20deg);
    left: 450px;
}
#Phrases3 {
    position: relative;
    zoom:0.5;
    transform:rotate(-20deg);
    left: 50px;
}

.animate {
    animation: fadeIn2 1s forwards ease-in;
    transition: 1s ease-in-out;
}

@keyframes fadeIn2 {
    0% {opacity: 0;} 
    100% { opacity: 1;  transform:rotate(-20deg) translateX(3em);}
}
@keyframes fadeIn {
    0% {opacity: 0;} 
    100% { opacity: 1; transform: translateY(-2em);}
}
@keyframes fadeIn3 {
    0% {opacity: 0; width:0 } 
    100% {opacity: 1; width:550px}
}
.animate2 {
    animation: fadeIn 1s forwards ease-in;
    transition: 1s ease-in-out;
}
.animate3 {
    animation: fadeIn 0.7s forwards ease-in;
    animation-delay: 0.5s;
    transition: 1s ease-in-out;
}
.animate4 {
    animation: fadeIn 0.5s forwards ease-in;
    animation-delay: 1s;
    transition: 1s ease-in-out;
}
.animate5 {
    animation: fadeIn3 0.5s forwards ease-in;
    animation-delay: 1.7s;
   
}

.content2 {
    position: relative;
    left:45%;
    margin-bottom:5%;
}
.content3 {
    position:absolute;
    left:40%;
    top:68%;
    transform:rotate(-15deg);
}
</style>