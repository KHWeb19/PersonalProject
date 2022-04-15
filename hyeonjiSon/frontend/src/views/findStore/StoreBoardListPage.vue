<template>
<div>
    <v-container>

      <!--로그인 되어있지 않을 때-->
        <v-toolbar-items v-if="this.$store.state.userInfo == null">
              <p> 우리 가게로 아이스팩 재활용하기에 참여하고 싶으시다면? </p>
              <v-spacer></v-spacer>
              <v-btn>
                <v-icon>
                    회원가입
                </v-icon>
            </v-btn>      
      </v-toolbar-items>

      <!--로그인 시에만 글쓰기 버튼이 보인다-->
      <v-toolbar-items v-if="this.$store.state.userInfo != null">
            <p> 우리 가게로 아이스팩 재활용하기에 참여하고 싶으시다면? </p>
              <v-spacer></v-spacer>
            <v-btn @click="register">
                <v-icon>
                    ADD
                </v-icon>
            </v-btn>  
      </v-toolbar-items>

    <table >
      <tr>
          <th align="center" width="80">시</th>
          <th align="center" width="80">구</th>
          <th align="center" width="80">동</th>
          <th align="center" width="300">주소</th>
          <th align="center" width="150">상호명</th>
      </tr>
      <tr v-if="!storeBoards || (Array.isArray(storeBoards) && storeBoards.length === 0)">
          <td align="center" colspan="5">
              현재 등록된 게시물이 없습니다!
          </td>
      </tr>
      <tr v-else v-for="storeBoard in paginatedData" :key="storeBoard.boardNo" @click="readPage">
          <td align="center"> {{ storeBoard.city }} </td>
          <td align="center"> {{ storeBoard.gu }} </td>
          <td align="center"> {{ storeBoard.dong }} </td>
          <td align="center"> {{ storeBoard.adress }} </td>
          <td align="center"> {{ storeBoard.storeName }} </td>
      </tr>
  </table>

      <div class="btn-cover">
        <button :disabled="pageNum === 0" @click="prevPage" class="page-btn">
            이전
        </button>
        <span class="page-count">{{ pageNum + 1 }} / {{ pageCount }} 페이지</span>
        <button :disabled="pageNum >= pageCount - 1" @click="nextPage" class="page-btn">
            다음
        </button>
    </div>



    </v-container>
</div>    
</template>

<script>
import { mapState, mapActions } from 'vuex'

export default {
    name: 'storeBoardListPage',
    props: {
      storeBoards: {
          type: Array
      },
      boardNo: {
          type: String,
          required: true
      }
    },
    computed: {
        ...mapState(['storeBoards']),
        pageCount () {
            let listLeng = this.storeBoards.length,
                listSize = this.pageSize,
                page = Math.floor(listLeng / listSize);
            if (listLeng % listSize > 0) page += 1
            return page;
        },
        paginatedData () {
            const start = this.pageNum * this.pageSize,
                    end = start + this.pageSize;
            return this.storeBoards.slice(start, end);
      }        
    },
    mounted () {
        this.fetchStoreBoardList()
    },
    methods: {
        ...mapActions(['fetchStoreBoardList']),
        register() {
           this.$router.push({ name:'storeRegisterPage' })
        },
        readPage() {
           this.$router.push({ name:'storeReadPage' })
        },
        nextPage () {
            this.pageNum += 1;
        },
        prevPage () {
            this.pageNum -= 1;
        }            
    }
}
</script>

<style scoped>
.td {
  margin: 20px;
}
.btn-cover {
  margin-top: 1.5rem;
  text-align: center;
}
.btn-cover .page-btn {
  width: 5rem;
  height: 2rem;
  letter-spacing: 0.5px;
}
.btn-cover .page-count {
  padding: 0 1rem;
}
</style>