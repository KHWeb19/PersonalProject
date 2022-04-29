<template>
    <div class="mt-14">
        <v-row justify="end">
            <v-col cols="12">
                <main-search id="ms" @search="doSearch" />
            </v-col>
            <v-col class="reBtn" v-if="keyword != '' ">
                <v-btn rounded color="red darken-3" dark @click="returnMain"><v-icon>mdi-backup-restore</v-icon></v-btn>
            </v-col>
        </v-row>
        <main-vellup v-if="keyword == '' " :communityBest="communityBest" :reviewBest="reviewBest"/>
        <search-result v-else :mainCommunityList="mainCommunityList" :mainMarketList="mainMarketList"
                                        :mainReviewList="mainReviewList" :mainStudyList="mainStudyList" 
                                        :mainProjectList="mainProjectList"/>
    </div>
</template>



<script>
import MainVellup from '@/components/MainVellup.vue'
import { mapActions, mapState } from 'vuex'
import MainSearch from '@/components/button/Search.vue'
import SearchResult from '@/components/SearchResult.vue'
export default {
    name: 'MainVellupPage',
    components: {
        MainVellup,
        MainSearch,
        SearchResult,

    },
    data () {
        return {
            keyword:'',
        }
    },
    computed: {
        ...mapState(['communityBest' ,'reviewBest', 'mainCommunityList', 'mainMarketList' , 'mainReviewList', 'mainStudyList', 'mainProjectList'])
    },
    mounted () {
        this.fetchCommunityBoardBestList()
        this.fetchReviewBestList()
    },
    methods: {
        ...mapActions(['fetchCommunityBoardBestList', 'fetchReviewBestList' ,'fetchMainCommunityList', 'fetchMainMarketList'
                                , 'fetchMainReviewList', 'fetchMainStudyList', 'fetchMainProjectList']),
        doSearch(keyword){
            this.keyword = keyword
            console.log(keyword)
            this.fetchMainCommunityList(keyword)
            this.fetchMainMarketList(keyword)
            this.fetchMainReviewList(keyword)
            this.fetchMainStudyList(keyword)
            this.fetchMainProjectList(keyword)
        },
        returnMain() {
             this.keyword = ''      
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
    outline-color: rgb(204, 32, 32);
    padding-left:10px;
    font-family: 'Noto Sans KR', sans-serif;
    float:left;
}
.reBtn{
    position: absolute;
    left:80%;
    
}
</style>