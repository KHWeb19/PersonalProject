<template>
<div align: right>
    <v-list-item-action>
        <v-icon>
            mdi-login
        </v-icon>
    </v-list-item-action>
    <v-list-item-action>
      <v-list-item-title @click="category">로그인</v-list-item-title>
    </v-list-item-action>

    <v-list-item-action>
        <v-icon>
            mdi-logout
        </v-icon>
    </v-list-item-action>
    <v-list-item-action>
      <v-list-item-title @click="category">로그아웃</v-list-item-title>
    </v-list-item-action>
    
  </div>
</template>

<script>
export default {
    
}
</script>