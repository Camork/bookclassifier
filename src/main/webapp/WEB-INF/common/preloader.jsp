<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<div id="modalPop" class="modal">
    <div class="modal-content">
        <h4>请选择导入类型</h4>

        <div>
            url链接和图片上传二选其一

            <form id="uploadForm" enctype="multipart/form-data">
                <div class="input-field">
                    <input id="imageUrl" type="text" name="imageUrl"/>
                    <label for="imageUrl">请输入网络图片url</label>
                </div>

                <div class="file-field input-field">
                    <div class="btn">
                        <span>Upload File</span>
                        <input type="file" name="imageFile">
                    </div>
                    <div class="file-path-wrapper">
                        <input class="file-path validate" type="text">
                    </div>
                </div>
            </form>
        </div>

    </div>

    <div class="modal-footer">
        <a class="modal-action modal-close waves-effect waves-green btn-flat" onclick="bookApi()">Submit</a>
    </div>
</div>

<div id="bookPop" class="modal" style="width: 70%">
    <div class="modal-content">
        <h4>请确定列表中可能的图书</h4>

        <div class="bookContainer">
        </div>
    </div>

    <div class="modal-footer">
        <a class="modal-action modal-close waves-effect waves-green btn-flat" onclick="">Submit</a>
    </div>
</div>