<template>
    <v-container>
        <v-row justify="center">
            <input type="text" class="mainSearch">
            <v-btn class="searchBtn" @click=goSearch color="red darken-3" dark>
                    <v-icon>
                        mdi-magnify
                    </v-icon>
            </v-btn>
        </v-row>
        <br/>
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
        <v-row justify="center">
            <v-col cols="5">
            여기는 Best 게시물 쓸거에요
            </v-col>
        </v-row>
        <v-row class="halfMain" justify="center">
            dd
            <p/>
            <p/>
            <br/>
            ddddd
        </v-row>
    </v-container>
</template>

<script>
export default {
    name:'MainVellup',
    data () {
        return {
            items: [
                {explain: 'a strong feeling of enthusiasm or excitement for something or about doing develop' ,content:'Passion', img: require('@/assets/main/main4.jpg') },
                {explain:'Our ideas about develop are always smart and interesting', content:'smart', img: require('@/assets/main/main3.png')},
                {explain:'We are the people who lead the future', content:'future', img: require('@/assets/main/main2.png')},
                {explain:'Do action of working with someone to produce or create idea', content:'collaboration', img: require('@/assets/main/main1.png')}
            ]
        }
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
    outline-color: rgb(211, 32, 32);
    padding-left:10px;
    font-family: 'Noto Sans KR', sans-serif;
    float:left;
}
.imgGallery{
    margin-top:3%;
    margin-left:auto;
    margin-right:auto;
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
.halfMain {
    margin-top:5%;
    background: linear-gradient(0deg, rgb(214, 214, 214), white);
    background-color: rgb(226, 222, 222);
    padding:10%;
}
</style>