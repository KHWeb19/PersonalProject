<template>
    <v-container>
        <v-row column wrap justify="center">
            <v-data-table v-if="keyword =='' "
                        :headers="headerTitle" 
                        :items="reviews"
                        :key="reviews.reviewNo"
                        :items-per-page="10"
                        class="elevation-1 grey lighten-4" 
                        >
                <template v-slot:[`item.title`]="{ item }">
                   <router-link :to="{ name: 'ReviewReadPage',
                                        params: { reviewNo: item.reviewNo.toString() } }"
                                        style="color:black; float:left">
                    {{ item.title }} &nbsp;&nbsp;&nbsp;&nbsp;
                   </router-link>
                   <div style="color:#D50000; float:left" >
                       [{{ item.commentCnt }}] &nbsp;
                   </div>
                   <div v-if="item.fileName1">
                       <v-icon style="zoom:0.9">
                           mdi-image
                       </v-icon>
                   </div>
                </template>
            </v-data-table>
            <v-data-table v-else
                        :headers="headerTitle" 
                        :items="mainReviewList"
                        :key="mainReviewList.reviewNo"
                        :items-per-page="10"
                        class="elevation-1 grey lighten-4" 
                        >
                <template v-slot:[`item.title`]="{ item }">
                   <router-link :to="{ name: 'ReviewReadPage',
                                        params: { reviewNo: item.reviewNo.toString() } }"
                                        style="color:black; float:left">
                    {{ item.title }} &nbsp;&nbsp;&nbsp;&nbsp;
                   </router-link>
                   <div style="color:#D50000; float:left" >
                       [{{ item.commentCnt }}] &nbsp;
                   </div>
                   <div v-if="item.fileName1">
                       <v-icon style="zoom:0.9">
                           mdi-image
                       </v-icon>
                   </div>
                </template>
            </v-data-table>
        </v-row>
        <v-row justify="center" class="mt-15 mb-5">
            <v-col cols="12" >
                <search @search="doSearch" />
            </v-col>
        </v-row>
        </v-container>
</template>

<script>
import Search from '@/components/button/Search.vue'
import { mapActions, mapState } from 'vuex'

export default {
  components: { Search },
    name:'ReviewList',
    props: {
        reviews: {
            type:Array
        }
    },
    data () {
        return {
            headerTitle: [
                { text:'글 번호', value: 'reviewNo', width:'70px'},
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
    computed: {
        ...mapState(['mainReviewList'])
    },
    methods: {
       ...mapActions(['fetchMainReviewList']),
        doSearch(keyword){
            this.keyword = keyword
            console.log(keyword)
            this.fetchMainReviewList(keyword)
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