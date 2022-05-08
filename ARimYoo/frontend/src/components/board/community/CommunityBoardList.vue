<template>
    <v-container>
        <v-row column wrap justify="center">
            <v-data-table v-if="keyword =='' "
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
            <v-data-table v-else
                        :headers="headerTitle" 
                        :items="mainCommunityList"
                        :key="mainCommunityList.boardNo"
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
        <v-row justify="center" class="mt-15 mb-5">
            <v-col cols="12" >
                <main-search @search="doSearch" />
            </v-col>
        </v-row>
        </v-container>
</template>

<script>
import MainSearch from '@/components/button/Search.vue'
import { mapActions, mapState } from 'vuex'

export default {
  components: { MainSearch },
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
    computed: {
        ...mapState(['mainCommunityList'])
    },
    methods: {
        ...mapActions(['fetchMainCommunityList']),
        doSearch(keyword){
            this.keyword = keyword
            console.log(keyword)
            this.fetchMainCommunityList(keyword)
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
</style>