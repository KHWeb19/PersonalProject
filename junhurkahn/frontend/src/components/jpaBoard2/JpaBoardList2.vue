<template>
    <div>
        <h3>장보기 목록</h3>
          <div class="input-group mb-3">
  <span class="input-group-text" id="inputGroup-sizing-default">Find</span>
  <input type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default">
</div>
       <table class="table">
             <tr align="center">
                <th scope="col">번호</th>
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
                
                <td align="center">
                    {{ board.regDate }} <button type="button" class="btn btn-primary btn-sm">완료</button>
<button type="button" class="btn btn-secondary btn-sm">미완료</button> 

                     
                </td>
            </tr>
        </table>
    </div>
</template>

<script>




export default {
    
   
    
    name: 'JpaBoardList2',
    props: {
      jpaBoards2: {
            type: Array
        }
    },

    data() {
      return {
          Incomplete : '미완료',
          false : '미완료',
          true : '완료',
           showCreditCard: true,
      
    
           
      }
    },

    methods: {
        
    
        changebutton() {
            
            this. Incomplete= !this.Incomplete
        },   
            
    },

    

  
}

      

    




</script>