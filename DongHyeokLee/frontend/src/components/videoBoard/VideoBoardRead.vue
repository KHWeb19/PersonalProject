<template>
    <div >
        
        <div class="title">
            <h2> {{ videoBoard.title }} </h2>
            <div class="subtitle">
                <p>{{ videoBoard.writer }}</p>
                <span> {{ videoBoard.regDate.substring(0, 10) }}</span>
                <span> {{new Date(videoBoard.regDate).toLocaleString("ko-KR", {timeZone: "Asia/Seoul"}).toString().substr(12, 11)}}</span>
            </div>
        </div>

        <div class="video">
            <iframe :src="require(`@/assets/uploadVideo/${videoBoard.fileName}`)" width="50%" height="400" allow="autoplay muted"></iframe>
        </div>
        
        <table>
            <tr>
                <td>
                   <div> {{ videoBoard.content }}</div>
                   
                </td>
            </tr>
        </table>
    </div>
</template>

<script>



export default {
    name: 'VideoBoardRead',
    props: {
        videoBoard: {
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