<template>
  <v-container>
        <header-view></header-view>
        <br>
     <div align="center">

        
        
        <product-board-read  :ProductBoardS="ProductBoardS" :boardNo=" boardNo"/>

       <!-- <read-question-comment :boardNo="boardNo"/>-->

        <div v-if="userInfo.id == ProductBoardS.id" style="padding:20px;">
            <router-link style="text-decoration: none; color:black" 
            :to="{ name: 'K2ProductModifyPage', params: { boardNo } }">
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
            :to="{ name: 'K2ProductView' }">
                <v-btn text color="black" rounded x-large
                        style="padding: 10px; width: 90px;">
                목록으로
                </v-btn>
            </router-link>
        </div>
    
    </v-container>   
</template>
<script>
import { mapState, mapActions } from 'vuex'
import axios from 'axios'
import HeaderView from '@/components/home/headerView.vue'
import  ProductBoardRead from '@/components/ProductBoard/ProductBoardRead.vue'
//import ReadQuestionComment from '@/components/comment/ReadQuestionComment'
export default {
    name:'K2ProductReadPage',
    components:{ 
    HeaderView,
    ProductBoardRead,
    //ReadQuestionComment,
    },
   
    props: {
        boardNo: {
            type: String,
            required: true
        }   
    },
    computed: {
        ...mapState(['ProductBoardS','userInfo'])
    },
    created () {
        this.fetchProductBoards(this.boardNo)
                .catch(err => {
                    alert(err.response.data.message)
                    this.$router.push()
                })
    },
    methods: {
        ...mapActions(['fetchProductBoards']),
        onDelete () {
            var result = confirm('삭제 하시겠습니까?')
            if(result) {
                const { boardNo } = this.ProductBoardS
                axios.delete(`http://localhost:7777/ProductBoardS/${boardNo}`)
                        .then(() => {
                            alert('삭제 되었습니다.')
                            this.$router.push({ name: 'K2ProductView' })
                        })
                        .catch(err => {
                            alert(err.response.data.message)
                        })
            }
        }
    }
}
</script>