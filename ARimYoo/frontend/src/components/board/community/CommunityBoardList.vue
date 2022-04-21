<template>
    <v-container>
        <v-row column wrap justify="center">
            <v-data-table 
                        :headers="headerTitle" 
                        :items="communityBoards"
                        :key="communityBoards.boardNo"
                        :items-per-page="10"
                        class="elevation-1 grey lighten-4" 
                        >
                <template v-slot:[`item.title`]="{ item }">
                   <router-link :to="{ name: 'CommunityReadPage',
                                        params: { boardNo: item.boardNo.toString() } }"
                                        style="color:black; float:left">
                    {{ item.title }} &nbsp;&nbsp;&nbsp;&nbsp;
                   </router-link>
                   <div style="color:#D50000; float:left" >
                       [{{ item.commentCnt }}] &nbsp;
                   </div>
                   <div v-if="item.fileName">
                       <v-icon style="zoom:0.9">
                           mdi-image
                       </v-icon>
                   </div>
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
    name:'CommunityBoardList',
    props: {
        communityBoards: {
            type:Array
        }
    },
    data () {
        return {
            headerTitle: [
                { text:'글 번호', value: 'boardNo', width:'70px'},
                { text:'말머리', value: 'brackets', width:'70px'},
                { text: '제목', value: 'title', width: "200px" },
                { text: '작성자', value: 'writer', width: "100px" },
                { text: '💛', value: 'likeCnt', width: "50px" },
                { text: '조회수', value: 'viewCnt', width: "70px" },
                { text: 'date. ', value: 'regDate', width: "100px" },
            ],
            keyword:'',
            searchList: []
        }
    },
    methods: {
        goSearch(){
                const {keyword} = this
                console.log(keyword)
                axios.post('http://localhost:7777/board/community/search', {keyword})
                .then((res) => {
                    console.log(res.data)
                    this.$router.push({name: 'CommunityBoardSearchPage', params: { searchList: res.data }})
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