<template>
 

  <div class="bx">

  <div>
        
    <div class="input-group mb-3">
  
  <span class="input-group-text"  id="inputGroup-sizing-default" @click="findSearch">Find</span>

<div class="box">
  <input type="text" 
        class="form-control" 
        ref="keyword"
        aria-label="Sizing example input" 
        aria-describedby="inputGroup-sizing-default">
</div>
</div>


  <table class="table table-succes table-striped">

          <tr align="center" table class="table-success"  >
                <th scope="col" >번호</th>
               <th scope="col">물건목록</th>
               <th scope="col">등록일자</th>
            </tr>
            <tr v-if="!jpaBoards2 || (Array.isArray(jpaBoards2) && jpaBoards2.length === 0)">
                <td colspan="4">
                    현재 등록된 게시물이 없습니다!
                </td>
            </tr>
            <tr v-else v-for="board in jpaBoards2" :key="board.boardNo">
                <td align="center">
                    {{ board.boardNo }} 
                </td>
                <td align="center">
                    <router-link :to="{ name: 'JpaBoardReadPage2',
                                        params: { boardNo: board.boardNo.toString() } }">
                        {{ board.title }}
                    </router-link>
                </td>
               
                <td align="center">
                    {{ board.regDate }}
                     <button type="button" class="btn btn-outline-primary" @click="toggleLable"> {{ label }}</button>
                     <button type="button" class="btn btn-outline-danger" @click="onDelete(board)">Delete</button>
                </td>
            </tr>
            
               <hr/>
               <nav aria-label="Page navigation example" >
      <ul class="pagination">
        <li class="page-item">
          <a class="page-link" href="#">
            Previous
          </a>
        </li>
        <li class="page-item">
          <a class="page-link" href="#">1</a>
        </li>
        <li class="page-item">
          <a class="page-link" href="#">2</a>
        </li>
        <li class="page-item">
          <a class="page-link" href="#">3</a>
        </li>
        <li class="page-item">
          <a class="page-link" href="#">Next</a>
        </li>
      </ul>
    </nav>

   </table>
    </div>
  </div>

  
</template>

<script>

import axios from 'axios'
import { mapActions,mapState} from 'vuex'


export default {
  
    name: 'JpaBoardList2',
    props: {
      jpaBoards2: {
            type: Array,
             required: true
        }
    },
    data() {
      return {
        label : '미완료',
      };
    },
  
      computed: {
        ...mapState(['jpaBoard2'])
       },

         methods: {
        ...mapActions([
            'fetchJpaBoard2',
            'fetchJpaBoardList2']),
        onDelete (board) {
            const { boardNo } = board;
            //alert('지우는 게시물 번호: ' + boardNo)
            axios.delete(`http://localhost:7777/62th/board2/${boardNo}`)
            .then(() => {
               
                this.fetchJpaBoardList2();
                this.$refs.keyword.value = '';
            })
            .catch(() => {
                alert('삭제 실패! 문제 발생!')
            })
        },

        findSearch() {
            const keyword = this.$refs.keyword.value;
            this.fetchJpaBoardList2(keyword);
        },
        
        toggleLable() {
          if (this.label == '미완료') {
            this.label = "완료";
          } else {
            this.label = "미완료"
          }
          }
        }
    }
   





    


</script>

<style scoped>

.basil {
  background-color: #FFFBE6 !important;
}

.box{
          background:white;
          width: 50%
        
        }
</style>