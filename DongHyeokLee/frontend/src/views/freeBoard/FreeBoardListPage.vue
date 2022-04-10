<template>
    <div id="freeBoard">
        <h2 id="title">자유게시판</h2>
        <free-board-list :freeBoards="freeBoards" />

    <router-link :to="{ name: 'FreeBoardRegisterPage'}">
        <v-btn v-if="$store.state.isLogin == true" class="register-btn" color="cyan lighten-3" dark>
            <v-icon>mdi-pencil-plus</v-icon>
            <span>등록</span>
        </v-btn>
    </router-link>
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
    computed: {
        ...mapState(['freeBoards']),  
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
/* rotuer-link*/
    a{
        text-decoration: none;
    }

    a:hover{
        text-decoration: none; 
    }

    #title {
        text-align: center;
        padding: 15px;   
    }

    .register-btn{
        margin-left:80%; 
        }

</style>