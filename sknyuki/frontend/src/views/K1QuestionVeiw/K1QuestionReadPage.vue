<template>
<div>
    <v-container>
        <header-view></header-view>
        <br>
     <div align="center">

        
        
        <question-board-read v-if="QuestionBoard" :QuestionBoard="QuestionBoard" :boardNo="boardNo"/>
        <p v-else>로딩중 ...... </p>

        <read-question-comment :boardNo="boardNo"/>

        <div v-if="userInfo.id == QuestionBoard.id" style="padding:20px;">
            <router-link style="text-decoration: none; color:black" 
            :to="{ name: 'K1QuestionModifyPage', params: { boardNo } }">
                <v-btn text color="black" rounded x-large
                        style="padding: 10px; width: 90px;">
                    수정하기
                </v-btn>
            </router-link>


            <v-btn text color="black" rounded x-large
                style="padding: 10px; width: 90px;" 
                @click="onDelete">
                    삭제하기
            </v-btn>
        </div>
            <br>

            <router-link style="text-decoration: none; color:black"
            :to="{ name: 'K1QuestionView' }">
                <v-btn text color="black" rounded x-large
                        style="padding: 10px; width: 90px;">
                목록으로
                </v-btn>
            </router-link>
        </div>
    
    </v-container>
    <footer-view/>
</div>
</template>
<script>
import { mapState, mapActions } from 'vuex'
import axios from 'axios'
import HeaderView from '@/components/home/headerView.vue'
import QuestionBoardRead from '@/components/QuestionBoard/QuestionBoardRead.vue'
import ReadQuestionComment from '@/components/comment/ReadQuestionComment'
import FooterView from '@/components/home/footerView.vue'
export default {
    name:'K1QuestionReadPage',
    components:{ 
    HeaderView,
    QuestionBoardRead,
    ReadQuestionComment,
        FooterView,
    },
   
    props: {
        boardNo: {
            type: String,
            required: true
        }   
    },
    computed: {
        ...mapState(['QuestionBoard','userInfo'])
    },
    created () {
        this.fetchQuestionBoard(this.boardNo)
                .catch(err => {
                    alert(err.response.data.message)
                    this.$router.push()
                })
    },
    methods: {
        ...mapActions(['fetchQuestionBoard']),
        onDelete () {
            var result = confirm('삭제 하시겠습니까?')
            if(result) {
                const { boardNo } = this.QuestionBoard
                axios.delete(`http://localhost:7777/QuestionBoard/${boardNo}`)
                        .then(() => {
                            alert('삭제 되었습니다.')
                            this.$router.push({ name: 'K1QuestionView' })
                        })
                        .catch(err => {
                            alert(err.response.data.message)
                        })
            }
        }
    }
}
</script>