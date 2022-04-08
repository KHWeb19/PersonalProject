<template>
    <div id="freeBoard">
        <h2>자유게시판</h2>
        <free-board-list :freeBoards="freeBoards" />
       
        <router-link :to="{ name: 'FreeBoardRegisterPage'}">
            <v-btn v-if="$store.state.isLogin == true" class="blue" dark>
                <v-icon>mdi-pencil-plus</v-icon>
                <span>등록</span>
            </v-btn>
        </router-link>

       <!-- <b-pagination
         v-model="currentPage"
         :total-rows="rows"
         :per-page="perPage"
         aria-controls="my-table"
         >
            
        </b-pagination> -->
    </div>
</template>

<script>


import { mapActions, mapState } from 'vuex'
import FreeBoardList from '@/components/freeBoard/FreeBoardList.vue'



export default {
    name: 'FreeBoardListPage',
    components: {
        FreeBoardList,
        
    },
     /* data() {
        return {
            perPage: 10, //몇개씩 보여줄지
            currentPage: 1, // 현재 페이지
           
    
            
        }
    },*/
    computed: {
        ...mapState(['freeBoards']),
           /*rows() {
             return this.freeBoards.totalElements // 총 갯수*/
        //}
        
    },
    mounted () {
        if(!this.$store.state.isLogin){
            alert('로그인하세요')
            this.$router.push({name: "HomeView"});
        }else{
        this.fetchFreeBoardList()
        
        }
        
    },
    methods: {
        ...mapActions(['fetchFreeBoardList'])
        
       
    }

}
</script>

<style scoped>

h2 {
    text-align: center;
    padding: 15px;
}

a {
    text-decoration: none;
    margin-left: 1230px;

}

    
</style>