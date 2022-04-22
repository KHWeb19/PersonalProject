<template>
  <v-card class="mr-6 my-3" v-if="isLogin">
    <v-card-text>
      <v-list-item-title>
        <p>내가 작성한 내역</p>
      </v-list-item-title>
      <v-divider></v-divider>

      <v-list-item-title  
        v-if="!qnaList || (Array.isArray(qnaList) && qnaList.length ===0)">
        <p>작성한 게시물이 없습니다.</p>
      </v-list-item-title>

      <v-list v-else v-for="list in qnaList" :key="list.index">
        <v-list-item-group>
          <v-list-item @click="readQnAPage(list.qnaNo)">
            <v-list-item-title>
              {{ list.title }}
            </v-list-item-title>
          </v-list-item>
        </v-list-item-group>
      </v-list>

    </v-card-text>
    
  </v-card>
</template>


<script>

import axios from 'axios'
import { mapState } from 'vuex'

export default {
  data () {
    return {
        qnaList: [],
    }
  },
  mounted () {
    const id = this.userInfo.id
    axios.get(`http://localhost:7777/qna/read/${id}`).then(res => {
      let list = res.data.reverse()
      if (list.length >= 3) {
        for (let i = 0; i < 3; i++) {
          this.qnaList.push({ qnaNo: list[i].qnaNo, title: list[i].title })
        }
      } else {
        for (let i = 0; i < list.length; i++) {
          this.qnaList.push({ qnaNo: list[i].qnaNo, title: list[i].title })
        }
      }
      
      console.log(this.qnaList)
    })
  },
  computed: {
    ...mapState([ 'userInfo', 'isLogin' ])
  },
  methods: {
    readQnAPage (qnaNo) {
      this.$router.push(
        { name: 'QnAReadPage', query: { qnaNo: qnaNo, id: this.userInfo.id} }
      )
    }
  }
}
</script>