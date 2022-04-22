<template>
    <v-container>
        <v-row column wrap justify="center">
            <v-data-table 
                        :headers="headerTitle" 
                        :items="markets"
                        :key="markets.boardNo"
                        :items-per-page="10"
                        class="elevation-1 grey lighten-4" 
                        >
                        <template v-slot:[`item.fileName1`] ="{item}">
                             <img v-if="item.fileName1 !== null && item.fileName1 !== 'null'" class="imgArea" 
                        :src="require(`@/assets/back/market/${item.fileName1}`)"
                        >
                        </template>
                <template v-slot:[`item.title`]="{ item }">
                    <v-row>
                   <router-link :to="{ name: 'MarketReadPage',
                                        params: { boardNo: item.boardNo.toString() } }"
                                        style="color:black; float:left">
                    {{ item.title }} &nbsp;&nbsp;&nbsp;&nbsp;
                   </router-link>
                   <div style="color:#D50000; float:left" >
                       [{{ item.commentCnt }}] &nbsp;
                   </div>
                    </v-row>
                </template>
            </v-data-table>
        </v-row>
        <v-row justify="center" style="margin-top:50px">
            <v-col  cols="7" md="3">
            <input type="text" class="search" v-model="keyword"/>
            </v-col>
            <v-col cols="2" md="1">
                <v-btn class="searchBtn" @click=goSearch color="red darken-3" dark small>
                    <v-icon>
                        mdi-magnify
                    </v-icon>
                </v-btn>
            </v-col>
        </v-row>
        </v-container>
</template>

<script>
import axios from 'axios'

export default {
    name:'ReviewList',
    props: {
        markets: {
            type:Array
        }
    },
    data () {
        return {
            headerTitle: [
                { text:'글 번호', value: 'boardNo', width:'70px'},
                { text:'카테고리', value: 'category', width:'80px'},
                { text:'📷', value:'fileName1', width:'80px'},
                { text: '제목', value: 'title', width: "200px" },
                { text: '가격', value: 'price', width: "100px" },
                { text: '판매자', value: 'writer', width: "100px" },
                { text: 'date. ', value: 'regDate', width: "75px" },
            ],
            keyword:'',
            searchList: []
        }
    },
    methods: {
        goSearch(){
                const {keyword} = this
                console.log(keyword)
                axios.post('http://localhost:7777/board/market/search', {keyword})
                .then((res) => {
                    console.log(res.data)
                    this.$router.push({name: 'MarketSearchPage', params: { searchList: res.data }})
                })
                .catch (() => {
                    alert('문제 발생!')
                })
            }
        }
    } 
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@700&display=swap');

.v-data-table {
    width:90%;
    font-family: 'Noto Sans KR', sans-serif;
}
.headerTitle{ 
  font-size: 20pt;
}
.v-data-table::v-deep th {
  font-size: 14px !important;
}
.imgArea {
    width:110px;
}
.search {
    position: relative;
    width:300px;
    height:30px;
    background-color: rgb(240, 238, 238);
    outline-color: rgb(211, 32, 32);
    padding-left:10px;
    font-family: 'Noto Sans KR', sans-serif;
    float:left;
}
.searchBtn {
    position: relative;
    float:left;
    margin-left:10%;
}
</style>