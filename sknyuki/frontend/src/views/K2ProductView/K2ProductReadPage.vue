<template>
<div>
  <v-container>
        <header-view></header-view>
        <br>
     <div align="center">

        
        
        <product-board-read  :ProductBoardS="ProductBoardS" :boardNo=" boardNo"/>

       <!-- <read-question-comment :boardNo="boardNo"/>-->

        <div v-if="userInfo.id == ProductBoardS.id" style="padding:20px;">
            <div v-if="ProductBoardS.soldCheck">
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
        </div>

        <div v-else style="padding:20px;">
            <div v-if="ProductBoardS.soldCheck">
             <v-layout justify-center>
            <v-dialog v-model="dialog" persisten max-width="400">
                <template v-slot:activator="{ on }">
                    <v-btn text color="black" rounded x-large
                        style="padding: 10px; width: 90px;" v-on="on">결제하기</v-btn>

                                
         <v-btn text color="black" rounded x-large
                style="padding: 10px; width: 90px;" 
                @click="toBasket">
                    장바구니
            </v-btn>
            
        
                </template>
                <v-card class=" rounded-xl pa-4">
                    <v-card-title class="headline secondary--text font-weight-bold">
                        상품 구매
                    </v-card-title>
                    <v-card-text>
                    <v-text-field
                        label="입금자명"
                        outlined 
                        style="width:600px; font-size:30px;"
                        ></v-text-field>
                    </v-card-text><br/>
                    <v-card-text>
                         결제 후 환불 불가합니다.
                    </v-card-text>
                    <v-card-actions>
                        <v-spacer></v-spacer>
                        <v-btn color="teal darken-1" text @click="cancel()">
                            취소
                        </v-btn>
                        <v-btn color="teal darken-1" text @click="buyProduct()">
                            결제승인
                        </v-btn>
                    </v-card-actions>
                </v-card>
            </v-dialog>
        </v-layout>
            </div>
              
           
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
    <footer-view/>
</div>
</template>
<script>
import { mapState, mapActions } from 'vuex'
import axios from 'axios'
import HeaderView from '@/components/home/headerView.vue'
import  ProductBoardRead from '@/components/ProductBoard/ProductBoardRead.vue'
import FooterView from '@/components/home/footerView.vue'
//import ReadQuestionComment from '@/components/comment/ReadQuestionComment'

export default {
    name:'K2ProductReadPage',
    components:{ 
    HeaderView,
    ProductBoardRead,
        FooterView,
    //ReadQuestionComment,
    },
    data(){
        return{
            dialog: false,
        }
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
        },
        buyProduct(){
            this.ProductBoardS.soldCheck=false
            const soldCheck=this.ProductBoardS.soldCheck
            axios.put(`http://localhost:7777/ProductBoardS/${this.boardNo}`,
                {   soldCheck,
                    type: this.ProductBoardS.type,
                    name: this.ProductBoardS.name,
                    size: this.ProductBoardS.size,
                    price: this.ProductBoardS.price,
                    brandrank: this.ProductBoardS.brandrank,
                    accessories: this.ProductBoardS.accessories,
                    status: this.ProductBoardS.status,
                    id: this.ProductBoardS.id, 
                    regDate: this.ProductBoardS.regDate })
                    .then(() => {
                        alert('제품을 구매하셨습니다.')
                    })
                    .catch(() => {
                        alert('에러발생')
                    })
                        console.log(this.ProductBoardS.soldCheck)
           //console.log(this.ProductBoardS.soldCheck)
           //console.log(this.userInfo.id)
           const id=this.userInfo.id
           const type=this.ProductBoardS.type
           const name=this.ProductBoardS.name
           const size=this.ProductBoardS.size
           const price=this.ProductBoardS.price
           const brandrank=this.ProductBoardS.brandrank
           const accessories=this.ProductBoardS.accessories
           const status=this.ProductBoardS.status
           const boardNo=this.ProductBoardS.boardNo
            axios.post('http://localhost:7777/ProductBoardB/register', { id, type, name, size, price ,brandrank ,accessories ,status ,boardNo})
                        this.$router.push({
                            name: 'K2ProductView'
                        })
                    },
        
        toBasket(){
            var result = confirm('장바구니에 등록 하시겠습니까?')
            if(result){
           const id=this.userInfo.id
           const type=this.ProductBoardS.type
           const name=this.ProductBoardS.name
           const size=this.ProductBoardS.size
           const price=this.ProductBoardS.price
           const brandrank=this.ProductBoardS.brandrank
           const accessories=this.ProductBoardS.accessories
           const status=this.ProductBoardS.status
           const boardNo=this.ProductBoardS.boardNo
            axios.post('http://localhost:7777/BasketBoard/register', { id, type, name, size, price ,brandrank ,accessories ,status ,boardNo})
                        this.$router.push({
                            name: 'K2ProductView'
            }
                        )}
        },
        cancel(){
            this.dialog=false
        },
    }
    }
</script>