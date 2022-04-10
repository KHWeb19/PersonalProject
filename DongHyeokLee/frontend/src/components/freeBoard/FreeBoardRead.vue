<template>
    <div>
        
        <div class="title">
            <h2> {{ freeBoard.title }} </h2>
            <div class="subtitle">
                <p class="writer">{{ freeBoard.writer }}     </p>
                <span class="day"> {{ freeBoard.regDate.substring(0, 10) }} 
                    {{new Date(freeBoard.regDate).toLocaleString("ko-KR", {timeZone: "Asia/Seoul"}).toString().substr(12, 8)}}
                </span>   
            </div>
        </div>

        <table>
            <tr>
                <td>
                    {{ freeBoard.content }}
                </td>
            </tr>
        </table>
    </div>
</template>

<script>



export default {
    name: 'FreeBoardRead',
    props: {
        freeBoard: {
            type: Object,
            required: true
        }
    },
    components: {
       
      
    }
}
</script>

<style scoped>
   

    .title{
       margin-left: 30%; 
       margin-bottom: 20px;
       
    }

    .subtitle{
        margin-top: 10px;
    }

    

     table {
    margin-left: 30%; 
    border-top: 1px solid ;
    border-collapse: collapse;
  }
  th {
    border-bottom: 1px solid ;
    border-left: 1px solid;
    padding: 10px;
  }

  td {    
    border-bottom: 1px solid;
    padding: 10px;
  }
  table{
      height: 500px;
      width: 500px;
      border: 1px solid;
  }
  .day {
      font-size: 17px;
      color: gray;
  }
    
  
</style>