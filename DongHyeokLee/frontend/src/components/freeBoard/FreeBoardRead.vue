<template>
    <div>
        <div class="title">
            <h3>{{ freeBoard.title }}</h3>
            <div class="subtitle">
                <p align="center" class="writer">{{ freeBoard.writer }} </p>
                <div class="day"> {{ freeBoard.regDate.substring(0, 10) }} 
                    {{new Date(freeBoard.regDate).toLocaleString("ko-KR", {timeZone: "Asia/Seoul"}).toString().substr(12, 8)}}
                </div>   
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
    padding:15px;
    color:black;
    width:500px
}
.subtitle{
    margin-top: 10px;
}
td {    
    border-top: 1px solid black;
    border-bottom: 1px solid black;
    padding: 10px;
    color: black;
}
table{
    margin-left: 30%; 
    height: 300px;
    width: 600px;
    border: 1px solid transparent;
}
.day {
    font-size: 15px;
    color: black;
    
}
.writer{
    background-color:#EEEEEE;
    width:120px;
    font-size: 20px;
    
}

    
  
</style>