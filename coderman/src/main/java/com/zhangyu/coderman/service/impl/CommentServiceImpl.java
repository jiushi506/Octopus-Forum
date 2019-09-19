package com.zhangyu.coderman.service.impl;

import com.zhangyu.coderman.dao.*;
import com.zhangyu.coderman.dto.CommentDTO;
import com.zhangyu.coderman.modal.Comment;
import com.zhangyu.coderman.modal.CommentExample;
import com.zhangyu.coderman.modal.Question;
import com.zhangyu.coderman.myenums.CommentType;
import com.zhangyu.coderman.service.CommentService;
import com.zhangyu.coderman.utils.DateFormateUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private QuestionExtMapper questionExtMapper;

    @Autowired
    private CommentExtMapper commentExtMapper;

    private  SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    @Autowired
    private UserMapper userMapper;

    @Transactional
    @Override
    public void doComment(Comment comment) {

        commentMapper.insertSelective(comment);
        if(comment.getType()==CommentType.COMMENT_ONE.getVal()){
            //question评论数增
            questionExtMapper.incCommentCount(comment.getParentId());
        }else {
            //comment的评论数增加
            commentExtMapper.incCommentCount(comment.getParentId());
        }

    }

    @Override
    public List<CommentDTO> findSecondComments(Integer id) {
        CommentExample commentExample = new CommentExample();
        commentExample.setOrderByClause("gmt_create desc");
        CommentExample.Criteria criteria = commentExample.createCriteria();
        criteria.andParentIdEqualTo(id);
        criteria.andTypeEqualTo(CommentType.COMMENT_TWO.getVal());
        List<Comment> comments = commentMapper.selectByExample(commentExample);
        List<CommentDTO> commentDTOS=null;
        if(comments.size()>0){
            commentDTOS=new ArrayList<>();
            for (Comment comment : comments) {
                CommentDTO commentDTO = new CommentDTO();
                BeanUtils.copyProperties(comment,commentDTO);
                commentDTO.setUser(userMapper.selectByPrimaryKey(comment.getCommentor()));
                String dateString = simpleDateFormat.format(new Date(comment.getGmtCreate()));
                String time = DateFormateUtil.getTime(dateString);
                commentDTO.setShowTime(time);
                commentDTOS.add(commentDTO);
            }
        }
        return commentDTOS;
    }
}
