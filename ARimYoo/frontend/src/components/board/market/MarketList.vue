<template>
    <v-container>
        <v-row column wrap justify="center">
            <v-data-table v-if="keyword =='' "
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
             <v-data-table v-else
                        :headers="headerTitle" 
                        :items="mainMarketList"
                        :key="mainMarketList.boardNo"
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
    computed: {
        ...mapState(['mainMarketList'])
    },
    methods: {
       ...mapActions(['fetchMainMarketList']),
        doSearch(keyword){
            this.keyword = keyword
            console.log(keyword)
            this.fetchMainMarketList(keyword)
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
</style>