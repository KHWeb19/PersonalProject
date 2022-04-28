<template>
    <v-container>
            <v-form enctype="multipart/form-data" >
                <table>
                    <v-row v-if="market.writer == this.$store.state.userInfo.name">
                        <v-menu offset-y bottom>
                            <template v-slot:activator="{ attrs, on }">
                                <v-btn
                                class="extraBtn"
                                color="red darken-3"
                                dark
                                fab
                                v-bind="attrs"
                                v-on="on"
                                >
                                <v-icon> mdi-dots-horizontal </v-icon>
                                </v-btn>
                            </template>
                            <v-list class="black" dark>
                                <v-list-item>
                                    <router-link :to="{name:'MarketModifyPage', 
                                    params: { boardNo: market.boardNo.toString()}}" style="color:white">Modify
                                    </router-link>
                                </v-list-item>
                                <v-list-item>
                                    <a @click=onDelete  style="color:white">Delete</a>
                                </v-list-item>
                            </v-list>
                    </v-menu>
                  </v-row>
                    <v-row>
                        <span class="date" rounded readonly> {{market.regDate}} </span>
                    </v-row>
                    <v-row  wrap justify="center">
                        <v-carousel hide-delimiters  height="auto">
                            <v-carousel-item 
                            v-for="(file, index) in checkFile()" :key="index" style="text-align:center">
                            <img 
                            :src="require(`@/assets/back/market/${file}`)" class="preview"/>
                            </v-carousel-item>
                        </v-carousel>
                    </v-row>
                     <v-divider/>
                    <v-row justify="start">
                        <v-col cols="1" class="label">Title</v-col>
                        <v-col cols="8" >
                            <div class="label2">
                            {{ market.category }}
                            {{ market.title }}
                            </div>
                        </v-col>
                        <v-col class="label2">
                            <v-chip color="red darken-3" dark large class="ml-10">
                                {{ market.usedCondition }}
                            </v-chip>
                        </v-col>
                    </v-row>
                    <v-row justify="start">
                        <v-col cols="1" class="label">Price</v-col>
                        <v-col cols="8" class="label2">
                            {{ market.price }} ₩
                        </v-col>
                        <v-col  cols="2" class="label2">
                            <v-icon class="ml-10">mdi-eye</v-icon> 
                                {{market.viewCnt}}
                        </v-col>
                    </v-row>
                    <v-row justify="center" class="mt-7">
                             <v-col cols="12">
                            <v-textarea style="white-space:pre-line" cols="70" rows="15" 
                            outlined color="red darken-3" readonly
                            :value="market.content">
                            </v-textarea>
                        </v-col>
                    </v-row>
                 
                    <v-row wrap>
                        <v-btn @click="goPage" class="backBtn" color="black" dark>back</v-btn>
                    </v-row>
                </table>
            </v-form>
    </v-container>
</template>

<script>
import axios from 'axios'
import { mapActions } from 'vuex'

export default {

    name:'MarketReading',
    props: {
        market: {
            type: Object,
            required: true
        }
    },
    data () {
        return {
        fileName1: this.market.fileName1,
        files : [
            this.market.fileName1, this.market.fileName2, this.market.fileName3, this.market.fileName4, this.market.fileName5
        ]
        }
    },
    created () {
        this.boardNo = this.market.boardNo
        this.who = this.$store.state.userInfo.id
    },
    methods: {
        ...mapActions(['fetchMarketCommentsList']),
        goPage () {
            this.$router.push('/market')
        },
        onDelete () {
            const { boardNo, fileName1, fileName2, fileName3, fileName4, fileName5 } = this.market
            //alert('지우는 게시물 번호: ' + boardNo)
            axios.delete(`http://localhost:7777/board/market/${boardNo}`, {fileName1,  fileName2, fileName3, fileName4, fileName5})
                    .then(() => {
                        alert('게시글이 삭제되었습니다.')
                        this.$router.push({ name: 'MarketPage' })
                    })
                    .catch(() => {
                        alert('삭제 실패! 문제 발생!')
                    })
        },
        checkFile () {
            for(var i = 0; i < this.files.length; i++) {
                console.log(i)
                if(this.files[i] != null) {
                    console.log(this.files[i])
                } else {
                    this.files.splice(i)
                }
            }
            return this.files
        }
    }
}
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@700&display=swap');
.label{
    margin-right:3%;
    text-align: center;
    padding-top: 30px;
    font-family: 'Noto Sans KR', sans-serif;
    font-size:15pt;
}
.label2{
     font-family: 'Noto Sans KR', sans-serif;
     margin-top:20px;
     font-size:13pt;
}
.v-divider {
    margin-top:50px;
    margin-bottom:30px;
}
.preview {
    position: relative;
    margin-left: auto;
    margin-right:auto;
    max-width:450px;
    height:450px;
}
table{
    position: relative;
    background-color: rgb(245, 244, 244);
    padding-left: 11%;
    padding-right: 11%;
    padding-top: 2%;
    padding-bottom: 7%;
    margin-left:auto;
    margin-right:auto;
}
.v-text-field{
    font-family: 'Noto Sans KR', sans-serif;
}
.date {
    font-family: 'Noto Sans KR', sans-serif;
    position: relative;
    left:70%;
    margin-top:3%;
    margin-bottom:5%;
}
.backBtn {
    zoom:1.2;
}
.extraBtn {
    position: absolute;
    margin-top:2%;
    left:87%;
}
a{
    text-emphasis: none;
  color:white;
}
.imgArea {
    position: relative;
    max-height: 500px;
    max-width: 600px;
    margin-top: 4%;
}
@media (max-width:700px){
    table {
        top:4%;
        margin-left:10px;
        zoom:60%;
        margin-bottom:50px;
    }
    .date {
        left:60%;
    }
    .label {
        margin-right:40px;
    }
}
</style>