<template>
  
    <v-container>
        <v-row>
            <board-read-form v-if="board" :board="board"/>            
        </v-row>
    </v-container>
</template>

<script>
import BoardReadForm from '@/components/board/community/BoardReadForm.vue'

import { mapActions, mapState } from 'vuex'

export default {
    name:'BoardRead',

    props: {
        boardNo: {
            type: String,
            required: true
        }
    },
    
    computed: {
        ...mapState(['board'])
    },

    components: {  
       BoardReadForm
    },
    created () {
        this.fetchBoard(this.boardNo)
                .catch(() => {
                    alert('게시물 요청 실패!')
                    console.log(this.boardNo)
                    this.$router.push()
                })
    },
    
    methods: {
        ...mapActions(['fetchBoard']),
              
    }
}
</script>

<style scoped>
.title{
    margin-top:5%;
    margin-bottom: 5%;
}
@media (max-width:700px){
    .title {
        margin-top:50px;
        margin-left:20px;
        width:200px;
    }
}
</style>
