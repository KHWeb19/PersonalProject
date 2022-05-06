<template>
<v-container>
  <v-row>
    
    <v-col>
  <v-card class="mr-6 my-3" v-if="isLogin" width="300">
    <v-card-text>
      <v-list-item-title>
        <p>판별 게시글 활동</p>
      </v-list-item-title>
      <v-divider></v-divider>
      <v-list-item-title  
        v-if="!BrandCheckList || (Array.isArray(BrandCheckList) && BrandCheckList.length ===0)">
        <p>작성한 게시물이 없습니다.</p>
      </v-list-item-title>
      <v-list v-else v-for="list in BrandCheckList" :key="list.index">
        <v-list-item-group>
          <v-list-item @click="readPage(list.boardNo)">
            <v-list-item-title>
              {{ list.title }}
            </v-list-item-title>
          </v-list-item>
        </v-list-item-group>
      </v-list>
      </v-card-text>
      </v-card>
  </v-col>
      
  
<v-col>
  <v-card class="mr-6 my-3" v-if="isLogin" width="300">
 <v-card-text>
      <v-list-item-title>
        <p>질문 게시글 활동</p>
      </v-list-item-title>
      <v-divider></v-divider>
<v-list-item-title  
        v-if="!QuestionBoardList || (Array.isArray(QuestionBoardList) && QuestionBoardList.length ===0)">
        <p>작성한 게시물이 없습니다.</p>
      </v-list-item-title>
      <v-list v-else v-for="list in QuestionBoardList" :key="list.index">
        <v-list-item-group>
          <v-list-item @click="readQuestionPage(list.boardNo)">
            <v-list-item-title>
              {{ list.title }}
            </v-list-item-title>
          </v-list-item>
        </v-list-item-group>
      </v-list>
    </v-card-text>
  </v-card>
  </v-col>

  <v-col>
  <v-card class="mr-6 my-3" v-if="isLogin" width="300">
 <v-card-text>
      <v-list-item-title>
        <p>판매 게시글 등록 내역</p>
      </v-list-item-title>
      <v-divider></v-divider>
<v-list-item-title  
        v-if="!ProductBoardSList || (Array.isArray(ProductBoardSList) && ProductBoardSList.length ===0)">
        <p>작성한 게시물이 없습니다.</p>
      </v-list-item-title>
      <v-list v-else v-for="list in ProductBoardSList" :key="list.index">
        <v-list-item-group>
          <v-list-item @click="readProductSPage(list.boardNo)">
            <v-list-item-title>
              {{ list.name }}
            </v-list-item-title>
          </v-list-item>
        </v-list-item-group>
      </v-list>
    </v-card-text>
  </v-card>
  </v-col>

<v-col>
  <v-card class="mr-6 my-3" v-if="isLogin" width="300">
 <v-card-text>
      <v-list-item-title>
        <p>구매 게시글 내역</p>
      </v-list-item-title>
      <v-divider></v-divider>
<v-list-item-title  
        v-if="!ProductBoardBList || (Array.isArray(ProductBoardBList) && ProductBoardBList.length ===0)">
        <p>작성한 게시물이 없습니다.</p>
      </v-list-item-title>
      <v-list v-else v-for="list in ProductBoardBList" :key="list.index">
        <v-list-item-group>
          <v-list-item @click="readProductBPage(list.boardNo)">
            <v-list-item-title>
              {{ list.name }}
            </v-list-item-title>
          </v-list-item>
        </v-list-item-group>
      </v-list>
    </v-card-text>
  </v-card>
  </v-col>


<v-col>
  <v-card class="mr-6 my-3" v-if="isLogin" width="300">
 <v-card-text>
      <v-list-item-title>
        <p>나의 장바구니</p>
      </v-list-item-title>
      <v-divider></v-divider>
<v-list-item-title  
        v-if="!BasketBoardList || (Array.isArray(BasketBoardList) && BasketBoardList.length ===0)">
        <p>장바구니 내역이 없습니다.</p>
      </v-list-item-title>
      <v-list v-else v-for="list in BasketBoardList" :key="list.index">
        <v-list-item-group>
          <v-list-item @click="readBasketPage(list.basketNo, list.boardNo)">
            <v-list-item-title>
              {{ list.name }}
            </v-list-item-title>
          </v-list-item>
        </v-list-item-group>
      </v-list>
    </v-card-text>
  </v-card>
  </v-col>

  </v-row>
</v-container>
</template>


<script>
import axios from 'axios'
import { mapState } from 'vuex'

export default {
  data () {
    return {
      BrandCheckList: [],
      QuestionBoardList:[],
      ProductBoardSList:[],
      ProductBoardBList:[],
      BasketBoardList:[],
    }
  },
  mounted () {
    const id = this.userInfo.id

    axios.get(`http://localhost:7777/BrandCheckBoard/userRead/${id}`).then(res => {
      let list = res.data.reverse()

     
       for (let i = 0; i < list.length; i++) {
          this.BrandCheckList.push({ boardNo: list[i].boardNo, title: list[i].title })
        }      
      
      
      console.log(this.BrandCheckList)
    }),
     axios.get(`http://localhost:7777/QuestionBoard/userRead/${id}`).then(res => {
      let list = res.data.reverse()

     
       for (let i = 0; i < list.length; i++) {
          this.QuestionBoardList.push({ boardNo: list[i].boardNo, title: list[i].title })
        }      
      
      
      console.log(this.QuestionBoardList)
    }),

    axios.get(`http://localhost:7777/ProductBoardS/userRead/${id}`).then(res => {
      let list = res.data.reverse()

     
       for (let i = 0; i < list.length; i++) {
          this.ProductBoardSList.push({ boardNo: list[i].boardNo, name: list[i].name })
        }      
      
      
      console.log(this.ProductBoardSList)
    }),
    axios.get(`http://localhost:7777/ProductBoardB/userRead/${id}`).then(res => {
      let list = res.data.reverse()

     
       for (let i = 0; i < list.length; i++) {
          this.ProductBoardBList.push({ boardNo: list[i].boardNo, name: list[i].name })
        }      
      
      
      console.log(this.ProductBoardBList)
    }),

     axios.get(`http://localhost:7777/BasketBoard/userRead/${id}`).then(res => {
      let list = res.data.reverse()

     
       for (let i = 0; i < list.length; i++) {
          this.BasketBoardList.push({ boardNo: list[i].boardNo ,basketNo: list[i].basketNo, name: list[i].name })
        }      
      
      
      console.log(this.ProductBoardBList)
    })
    
  },
  computed: {
    ...mapState([ 'userInfo', 'isLogin' ])
  },
  methods: {
    readPage (boardNo) {
      this.$router.push(
        { name: 'K1CheckBrandReadPage', params: { boardNo: boardNo} }
      )
    },
     readQuestionPage (boardNo) {
      this.$router.push(
        { name: 'K1QuestionReadPage', params: { boardNo: boardNo} }
      )
     },
      readProductSPage (boardNo) {
      this.$router.push(
        { name: 'K2ProductReadPage', params: { boardNo: boardNo} }
      )
     },
     readProductBPage(boardNo){
        this.$router.push(
        { name: 'K2SoldReadPage', params: { boardNo: boardNo} }
      )
     },

     readBasketPage(basketNo,boardNo){
        this.$router.push(
        { name: 'K3basketReadPage', params: { basketNo: basketNo, boardNo:boardNo} }
      )
     },
  }
}
</script>