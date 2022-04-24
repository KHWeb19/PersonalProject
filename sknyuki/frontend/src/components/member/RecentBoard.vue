<template>
  <v-card class="mr-6 my-3" v-if="isLogin">
    <v-card-text>
      <v-list-item-title>
        <p>최근 게시글 활동</p>
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
      
      <v-divider></v-divider>

    </v-card-text>
    
  </v-card>
</template>


<script>
import axios from 'axios'
import { mapState } from 'vuex'

export default {
  data () {
    return {
      BrandCheckList: [],
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
    })
  },
  computed: {
    ...mapState([ 'userInfo', 'isLogin' ])
  },
  methods: {
    readPage (boardNo) {
      this.$router.push(
        { name: 'K1CheckBrandReadPage', query: { boardNo: boardNo} }
      )
    },
  }
}
</script>