<template>
  <div>
    <menu-bar/>
    <v-container style="width: 1000px; height: 382px; margin-top: 20px;">
      <v-flex style="text-align: center;">
        <v-card>
              <form @submit.prevent="onSubmit">
          <table style="width: 500px; height: 382px; margin: 0px 0px 0px 200px;">
              <tr>
                  <td style="text-align: right;">이름</td>
                  <td>
                      <input style="
                                margin: 3px;
                                border: 1px solid #d6d6d6; 
                                border-radius: 3px; 
                                width: 268px; 
                                height: 38px;
                                padding-left: 5px;" 
                                type="text" />
                  </td>
              </tr>
              <tr>
                  <td style="text-align: right;">아이디</td>
                  <td>
                      <input style="
                                margin: 3px;
                                border: 1px solid #d6d6d6; 
                                border-radius: 3px; 
                                width: 268px; 
                                height: 38px;
                                padding-left: 5px;" 
                                type="text" />
                  </td>
              </tr>
              <tr>
                  <td style="text-align: right;">비밀번호</td>
                  <td>
                      <input style="
                                margin: 3px;
                                border: 1px solid #d6d6d6; 
                                border-radius: 3px; 
                                width: 268px; 
                                height: 38px;
                                padding-left: 5px;" 
                                type="text" />
                  </td>
              </tr>
              <tr>
                  <td style="text-align: right;">자기소개</td>
                  <td>
                      <textarea style="
                                margin: 3px;
                                border: 1px solid #d6d6d6; 
                                border-radius: 3px; 
                                width: 268px; 
                                min-height: 60px;
                                padding-left: 5px;" 
                                type="text" >
                      </textarea>
                  </td>
              </tr>
          </table>
              </form>
        </v-card>
      </v-flex>

    </v-container>

  </div>
</template>

<script>
import MenuBar from '@/components/MenuBar.vue'

export default {
  components: {
    MenuBar
  }
}
</script>

<style>


</style>