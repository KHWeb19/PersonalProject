<template>
    <div >
        
        <div class="title">
            <h2> {{ photoBoard.title }} </h2>
            <div class="subtitle">
                <p>{{ photoBoard.writer }}</p>
                <span> {{ photoBoard.regDate.substring(0, 10) }}</span>
                <span> {{new Date(photoBoard.regDate).toLocaleString("ko-KR", {timeZone: "Asia/Seoul"}).toString().substr(11, 8)}}</span>
            </div>
        </div>

        <div class="img">
            <v-img :src="require(`@/assets/uploadImg/${photoBoard.fileName}`)" width="50%" height="400"></v-img>
        </div>
        
        <table>
            <tr>
                <td>
                   <div> {{ photoBoard.content }}</div>
                   
                </td>
            </tr>
        </table>
    </div>
</template>

<script>



export default {
    name: 'PhotoBoardRead',
    props: {
        photoBoard: {
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

    .img {
        margin-left: 30%;
        margin-bottom: 20px;
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

  
</style>